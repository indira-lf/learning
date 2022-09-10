package com.feng.rocketmq.product;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/10 13:55
 * @Description- 异步消息发送生产者
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //创建一个producer，参数为Producer Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        //指定NameServer地址
        producer.setNamesrvAddr("172.27.237.23:9876");
        //指定异步发送失败后不进行重试发送
        producer.setRetryTimesWhenSendAsyncFailed(0);
        //指定新创建的Topic的Queue数量为2，默认为4
        producer.setDefaultTopicQueueNums(2);

        producer.setSendMsgTimeout(60000);
        //开启生产者
        producer.start();

        for (int i=0; i<10; i++){
            byte[] body = ("Hi,"+i).getBytes();
            try {
                Message msg = new Message("someTopic","someTage",body);
                // 异步发送。指定回调
                producer.send(msg, new SendCallback() {
                    // 当producer接收到MQ发送来的ACK后就会触发该回调方法的执行
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println(sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(5);
        producer.shutdown();
    }
}
