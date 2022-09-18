package com.feng.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author
 * @time 2022/9/18 8:43
 * @Description- TODO
 */
public class SocketChannelDemo {
    public static void main(String[] args) {
        socketDemo();
    }

    public static void socketDemo() {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));

            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
            socketChannel.read(byteBuffer);
            socketChannel.close();
            System.out.println("read over");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
