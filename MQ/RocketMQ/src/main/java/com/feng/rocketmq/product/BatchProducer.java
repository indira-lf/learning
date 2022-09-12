package com.feng.rocketmq.product;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @time 2022/9/12 17:15
 * @Description- 批量生产
 */
public class BatchProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("172.27.237.23:9876");
        producer.setMaxMessageSize(4 * 1024 * 1024);
        producer.start();

        ArrayList<Message> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hi,"+i).getBytes();
            Message msg = new Message("batchTopic", "batchTag", body);
            messages.add(msg);
        }

        MessageListSplitter splitter = new MessageListSplitter(messages);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}
