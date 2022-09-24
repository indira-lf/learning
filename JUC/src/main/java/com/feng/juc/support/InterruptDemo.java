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
        /*
            线程中断demo
         */
//        i1();
//        i2();
        /*
            interrupt Demo
         */
//        i3();
//        i4();
        /*
         线程sleap(),interrupt不能停止问题
         */
//        i5();
        /*
            静态方法interrupted Demo
         */
        i6();
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

    /**
     * interrupt方法默认为false
     * 当一个线程调用interrupt方法的时候，interrupt置为true仅此而已
     */
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

        System.out.println(a.isInterrupted());
        a.interrupt();
        System.out.println(a.isInterrupted());

    }
    /**
     * 当一个线程调用interrupt方法的时候，interrupt置为true,线程并不会立刻停止
     */
    private static void i4() {
        Thread a = new Thread(() -> {
            for (int i=1; i<=3000;i++) {
                System.out.println("-->"+i);
            }
            System.out.println("a02:"+Thread.currentThread().isInterrupted());
        }, "a");
        a.start();
        System.out.println("a线程的中断标识位："+a.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.interrupt();
        System.out.println("a01:"+a.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a03:"+a.isInterrupted());
    }

    private static void i5() {
        Thread a = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("------------>程序结束");
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) { //线程中断标志位为false，无法停止，需要再次interrupt
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("hello Interrupted");
            }
        }, "a");
        a.start();
        System.out.println("a线程的中断标识位："+a.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }

    private static void i6() {
        System.out.println(Thread.currentThread().getName()+"----"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"----"+Thread.interrupted());
        System.out.println("====1====");
        Thread.currentThread().interrupt(); // false -> true
        System.out.println("====2====");
        System.out.println(Thread.currentThread().getName()+"----"+Thread.interrupted()); //返回true，true->false
        System.out.println(Thread.currentThread().getName()+"----"+Thread.interrupted());
    }
}
