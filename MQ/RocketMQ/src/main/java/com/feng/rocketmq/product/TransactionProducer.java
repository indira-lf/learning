package com.feng.rocketmq.product;

import com.feng.rocketmq.listener.ICBCTranscationListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/12 15:11
 * @Description- 半事务消息
 */
public class TransactionProducer {
    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("tpg");
        producer.setNamesrvAddr("172.27.237.23:9876");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });

        //为生产者指定一个线程池
        producer.setExecutorService(executor);
        //为生产者添加事务监听器
        producer.setTransactionListener(new ICBCTranscationListener());

        producer.start();

        String[] tags = {"TAGA","TAGB","TAGC"};
        for (int i=0; i<3; i++){
            byte[] body = ("Hi,"+i).getBytes();
            Message msg = new Message("TTopic", tags[i], body);
            TransactionSendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.println("发送结果为："+sendResult.getSendStatus());
        }
    }
}
