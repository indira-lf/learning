package com.feng.rocketmq.product;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author
 * @time 2022/9/9 21:24
 * @Description- 定义同步消息发送生产者
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {

        //创建一个producer，参数为Producer Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        //指定NameServer地址
        producer.setNamesrvAddr("172.27.237.23:9876");

        producer.setSendMsgTimeout(60000);
        //开启生产者
        producer.start();

        for (int i=0; i<10; i++){
            byte[] body = ("Hi,"+i).getBytes();
            Message msg = new Message("someTopic","someTage",body);
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
