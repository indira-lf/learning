package com.feng.juc.support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author
 * @time 2022/9/23 23:11
 * @Description- 线程中断
 */
public class InterruptDemo {

    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
//        i1();
//        i2();
        i3();
    }

    private static void i1() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println("isStop="+isStop);
                    break;
                }
                System.out.println("hello isStop");
            }
        },"a").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop = true;
        },"b").start();
    }
    private static void i2() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println("atomicBoolean="+atomicBoolean.get());
                    break;
                }
                System.out.println("hello atomicBoolean");
            }
        },"a").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            atomicBoolean.set(true);
        },"b").start();
    }
    private static void i3() {
        Thread a = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted结束");
                    break;
                }
                System.out.println("hello Interrupted");
            }
        }, "a");
        a.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            a.interrupt();
        },"b").start();
    }
}
