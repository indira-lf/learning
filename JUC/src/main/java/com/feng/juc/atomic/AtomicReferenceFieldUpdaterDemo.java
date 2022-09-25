package com.feng.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author
 * @time 2022/9/24 19:45
 * @Description- TODO
 */
class MyVar {
    public volatile Boolean isInit = Boolean.FALSE;
    AtomicReferenceFieldUpdater<MyVar,Boolean> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyVar.class,Boolean.class,"isInit");
    public void init(MyVar myVar) {
        if (fieldUpdater.compareAndSet(myVar,Boolean.FALSE,Boolean.TRUE)){
            System.out.println(Thread.currentThread().getName()+"\t"+"----start");
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"----end");
        }else {
            System.out.println(Thread.currentThread().getName() + "\t"+"----抢夺失败");
        }
    }

}
class MyVar1 {
    public volatile Integer isInit = 0;
    AtomicReferenceFieldUpdater<MyVar1,Integer> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyVar1.class,Integer.class,"isInit");
    public void init(MyVar1 myVar) {
        if (fieldUpdater.compareAndSet(myVar,0,1)){
            System.out.println(Thread.currentThread().getName()+"\t"+"----start");
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"----end");
        }else {
            System.out.println(Thread.currentThread().getName() + "\t"+"----抢夺失败");
        }
    }

}

public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyVar1 myVar = new MyVar1();
        for (int i=0; i< 50; i++) {
            new Thread(() -> {
                myVar.init(myVar);
            },String.valueOf(i)).start();
        }
    }
}