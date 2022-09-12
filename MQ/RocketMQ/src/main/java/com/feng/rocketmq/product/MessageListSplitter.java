package com.feng.rocketmq.product;

import org.apache.rocketmq.common.message.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @time 2022/9/12 17:22
 * @Description- TODO
 */
public class MessageListSplitter implements Iterator<List<Message>> {

    private final int SIZE_LIMIT = 4 * 1024 * 1024;
    private final List<Message> messages;

    private int currIndex;

    public MessageListSplitter(List<Message> messages){
        this.messages = messages;
    }


    @Override
    public boolean hasNext() {
        return currIndex < messages.size();
    }

    @Override
    public List<Message> next() {
        int nextIndex = currIndex;
        // 记录当前要发送的这一小批次消息列表的大小
        int totalSize = 0;
        for (; nextIndex < messages.size(); nextIndex++) {
            // 获取当前遍历的消息
            Message message = messages.get(nextIndex);
            // 统计当前遍历的message的大小
            int tmpSize = message.getTopic().length() + message.getBody().length;
            Map<String, String> properties = message.getProperties();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                tmpSize += entry.getKey().length() + entry.getValue().length();
            }
            tmpSize = tmpSize + 20;
            // 判断当前消息本身是否大于4M
            if (tmpSize > SIZE_LIMIT) {
                if (nextIndex - currIndex == 0) {
                    nextIndex++;
                }break;
            }
            if (tmpSize + totalSize > SIZE_LIMIT) {
                break;
            } else {
                totalSize += tmpSize;
            }
        }
        // end-for
        // 获取当前messages列表的子集合[currIndex, nextIndex)
        List<Message> subList = messages.subList(currIndex, nextIndex);
        // 下次遍历的开始索引
        currIndex = nextIndex;
        return subList;
    }
}
