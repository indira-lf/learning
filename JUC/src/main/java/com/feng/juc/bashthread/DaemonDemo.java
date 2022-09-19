package com.feng.juc.bashthread;

/**
 * @author
 * @time 2022/9/19 21:33
 * @Description- 守护线程
 *
 * 如果用户线程全部结束了，意味着程序需要完成的业务操作已经结束了，系统可以退出
 * 了。所以当系统只剩下守护进程的时候，java虚拟机会自动退出
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"come in: \t"
            + (Thread.currentThread().isDaemon()?"守护线程":"用户线程"));
            while (true) {

            }
        }, "a");
        a.setDaemon(true);
        a.start();

        System.out.println(Thread.currentThread().getName()+" over!");
    }
}
