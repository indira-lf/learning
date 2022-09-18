package com.feng.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author
 * @time 2022/9/18 8:29
 * @Description- TODO
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) {
        socket();
    }

    public static void socket() {

        try {
            //端口号设置
            int port = 8888;

            //buffer
            ByteBuffer buffer = ByteBuffer.wrap("hello Socket".getBytes());
            //socket
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(port));

            //设置非阻塞模式
            ssc.configureBlocking(false);

            //监听有链接传入
            while (true) {
                System.out.println("Waiting for connections");
                SocketChannel sc = ssc.accept();
                if (sc == null){
                    System.out.println("null");
                    Thread.sleep(2000);
                } else {
                    System.out.println("Incoming connection from: "+sc.socket().getRemoteSocketAddress());
                    buffer.rewind();
                    sc.write(buffer);
                    sc.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
