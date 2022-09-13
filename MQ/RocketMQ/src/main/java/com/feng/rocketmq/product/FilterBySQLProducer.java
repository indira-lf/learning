package com.feng.rocketmq.product;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author
 * @time 2022/9/12 19:52
 * @Description- 过滤消息
 */
public class FilterBySQLProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("172.27.237.23:9876");
        producer.start();

        String[] tags = {"myTagA","myTagB","myTagC"};
        for (int i=0; i<10; i++){
            byte[] body = ("Hi"+i).getBytes();
            Message msg = new Message("myTopic","myTag",body);
            msg.putUserProperty("age", i + "");
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
