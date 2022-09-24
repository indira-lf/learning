package com.feng.juc.support;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @time 2022/9/24 14:52
 * @Description- TODO
 */
public class LockSupportDemo {
    static Object object = new Object();
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
//        l1();
//        l2();
        l3();
    }
    /**
     *          synchronized
     *
     *
     * wait                     notify
     */
    public static void l1(){
        new Thread(() -> {
            synchronized (object){
                try {
                    System.out.println("-----1-----");
                    object.wait();
                    System.out.println("-----2-----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        new Thread(() -> {
            synchronized (object){
                    System.out.println("-----3-----");
                    object.notify();
                    System.out.println("-----4-----");
            }
        },"b").start();
    }

    /**
     *          lock
     *
     *
     * await                     signal
     */
    public static void l2(){
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-----1-----");
                condition.await();
                System.out.println("-----2-----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"a").start();

        new Thread(() -> {
            lock.lock();
            System.out.println("-----3-----");
            condition.signal();
            System.out.println("-----4-----");
            lock.unlock();
        },"b").start();
    }

    /**
     *          LockSupport
     *
     *
     * park                     unpark
     */
    public static void l3(){
        Thread a = new Thread(() -> {
            System.out.println("-----1-----");
            LockSupport.park();
            System.out.println("-----2-----");
        }, "a");
        a.start();

        new Thread(() -> {
            System.out.println("-----3-----");
            LockSupport.unpark(a);
            System.out.println("-----4-----");
        },"b").start();
    }
}
