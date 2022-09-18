package com.feng.nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/18 8:51
 * @Description- TODO
 */
public class DatagramChannelDemo {

    /**
     * 发送的实现
     */
    @Test
    public void sendDatagram() throws Exception {
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);

        while (true) {
            ByteBuffer buffer = ByteBuffer.wrap("aaaa".getBytes("UTF-8"));
            sendChannel.send(buffer,address);
            System.out.println("已经完成发送");
            TimeUnit.SECONDS.sleep(2);
        }

    }

    /**
     * 接收的实现
     */
    @Test
    public void receiveDatagram() throws Exception {
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress address = new InetSocketAddress(9999);

        receiveChannel.bind(address);

        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

        while (true) {
            receiveBuffer.clear();

            SocketAddress socketAddress = receiveChannel.receive(receiveBuffer);

            receiveBuffer.flip();
            System.out.println(socketAddress.toString());

            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
        }
    }

    @Test
    public void testConnect() throws Exception {
        DatagramChannel connect = DatagramChannel.open();
        InetSocketAddress address = new InetSocketAddress(9999);

        connect.bind(address);
        connect.connect(new InetSocketAddress("127.0.0.1", 9999));

        connect.write(ByteBuffer.wrap("aaa".getBytes(StandardCharsets.UTF_8)));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
         while (true) {
             buffer.clear();

             SocketAddress socketAddress = connect.receive(buffer);

             buffer.flip();
             System.out.println(socketAddress.toString());

             System.out.println(Charset.forName("UTF-8").decode(buffer));
         }
    }
}
