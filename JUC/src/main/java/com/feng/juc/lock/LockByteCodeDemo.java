package com.feng.juc.lock;

/**
 * @author
 * @time 2022/9/22 21:02
 * @Description- 从字节码的角度分析synchronized实现
 *
 * javap -v LockByteCodeDemo.class
 */
public class LockByteCodeDemo {
    Object object = new Object();

    /**
     * 一个 monitorenter指令，两个monitorexit(一个正常退出，一个异常退出)
     */
    public void m1(){
        synchronized (object){
            System.out.println("--------------hello");
        }
    }

    /**
     * flags标志上多了ACC_SYNCHRONIZED
     * flags: ACC_PUBLIC, ACC_SYNCHRONIZED
     */
    public synchronized void m2(){
        System.out.println("--------");
    }

    /**
     * flags标志位相对于m2()多了一个ACC_STATIC
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     */
    public static synchronized void m3() {
        System.out.println("--------");
    }

}
