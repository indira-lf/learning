package com.feng.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @time 2022/9/22 21:42
 * @Description- TODO
 */
public class SaleTicketDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> {for (int i = 1; i< 55; i++) ticket.sale();},"a").start();
        new Thread(() -> {for (int i = 1; i< 55; i++) ticket.sale();},"b").start();
        new Thread(() -> {for (int i = 1; i< 55; i++) ticket.sale();},"c").start();
        new Thread(() -> {for (int i = 1; i< 55; i++) ticket.sale();},"d").start();
        new Thread(() -> {for (int i = 1; i< 55; i++) ticket.sale();},"e").start();
    }
}

class Ticket {
    private int number = 50;

    private Lock lock = new ReentrantLock(true); //默认非公平

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第："+(number--)+ "\t 还剩下："+number);
            }
        }finally {
            lock.unlock();
        }
    }
}
