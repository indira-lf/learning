package com.feng.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/22 22:29
 * @Description- 死锁
 * 方法一:
 *      jps -l 查看进程
 *      jstack 进程号
 * 方法二:
 *      jconsole
 */
public class DeadLockDemo {
    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName()+"尝试获取B锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName()+"获取到B锁");
                }
            }
        },"A").start();
        new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"尝试获取A锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName()+"获取到A锁");
                }
            }
        },"B").start();
    }
}
