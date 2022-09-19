package com.feng.juc.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/19 21:53
 * @Description- TODO
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " come in \t");
            TimeUnit.SECONDS.sleep(2);
            return 1024;
        });

        new Thread(futureTask,"t1").start();

        System.out.println(Thread.currentThread().getName() + "继续");

//        System.out.println(futureTask.get()); //get()会导致阻塞
//        System.out.println(futureTask.get(2L,TimeUnit.SECONDS)); //过时不候

        //轮询代替阻塞
        while (true) {
            if (futureTask.isDone()){
                System.out.println("-----over!-----");
                break;
            }else {
                System.out.println("---------------");
            }
        }
    }
}
