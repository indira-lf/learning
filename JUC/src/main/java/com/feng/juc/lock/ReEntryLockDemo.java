package com.feng.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @time 2022/9/22 22:16
 * @Description- TODO
 */
public class ReEntryLockDemo {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
    }

    /**
     * ReentrantLock的可重入性
     */
    public static void reenLock(){
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("----1----");
                lock.lock();
                try {
                    System.out.println("----2----");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
    /**
     * synchronized的可重入性
     */
    static Object object = new Object();
    public static void syncBlock() {
        new Thread(() -> {
            synchronized (object){
                System.out.println("----1----");
                synchronized (object) {
                    System.out.println("----2----");
                    synchronized (object){
                        System.out.println("--- 3----");
                    }
                }
            }
        }).start();
    }
}
