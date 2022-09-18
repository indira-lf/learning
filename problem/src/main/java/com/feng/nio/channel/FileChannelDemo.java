package com.feng.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author
 * @time 2022/9/17 20:05
 * @Description-
 *
 */
public class FileChannelDemo {
    public static void main(String[] args) {

//        fileChannelRead();
//        fileChannelWrite();
//        fileChannelTransFrom();
        fileChannelTransTo();
    }

    /**
     * 文件读
     */
    public static void fileChannelRead(){
        try {
            //创建FileChannel
            RandomAccessFile accessFile = new RandomAccessFile("F:\\01.txt","rw");
            FileChannel channel = accessFile.getChannel();

            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int read = channel.read(buffer);
            while (read != -1) {
                System.out.println("读取了："+read);
                buffer.flip(); //反转读写模式
                while (buffer.hasRemaining()){
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
                read = channel.read(buffer);
            }
            channel.close();
            accessFile.close();
            System.out.println("结束...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件写
     */
    public static void fileChannelWrite() {
        try {
            //创建FileChannel
            RandomAccessFile accessFile = new RandomAccessFile("F:\\01.txt", "rw");
            FileChannel channel = accessFile.getChannel();

            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            String newData = "data nio";
            buffer.clear();

            //写入内容
            buffer.put(newData.getBytes());

            buffer.flip();

            //FileChannel实现最终方法
            while (buffer.hasRemaining()){
                channel.write(buffer);
            }

            channel.close();
            accessFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通道间数据传输From
     */
    public static void fileChannelTransFrom() {
        //创建FileChannel
        try {
            RandomAccessFile accessFile1 = new RandomAccessFile("F:\\01.txt", "rw");
            FileChannel fromChannel = accessFile1.getChannel();
            RandomAccessFile accessFile2 = new RandomAccessFile("F:\\02.txt", "rw");
            FileChannel toChannel = accessFile2.getChannel();

            long position = 0;
            long size = fromChannel.size();
            toChannel.transferFrom(fromChannel,position,size);

            accessFile1.close();
            accessFile2.close();
            System.out.println("结束");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通道间数据传输To
     */
    public static void fileChannelTransTo() {
        try {
            RandomAccessFile accessFile1 = new RandomAccessFile("F:\\01.txt", "rw");
            FileChannel fromChannel = accessFile1.getChannel();
            RandomAccessFile accessFile3 = new RandomAccessFile("F:\\03.txt", "rw");
            FileChannel toChannel = accessFile3.getChannel();

            long position = 0;
            long size = fromChannel.size();
            fromChannel.transferTo(0,size,toChannel);

            accessFile1.close();
            accessFile3.close();
            System.out.println("结束");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
