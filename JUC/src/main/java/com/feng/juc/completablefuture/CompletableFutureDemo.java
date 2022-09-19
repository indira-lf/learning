package com.feng.juc.completablefuture;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/20 7:08
 * @Description- TODO
 */
public class CompletableFutureDemo {

    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


    public static void main(String[] args) {
//        f1();
        f2();
        poolExecutor.shutdown();
    }

    public static void f1() {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
        },poolExecutor);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
        },poolExecutor);

    }
    public static void f2() {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 11;
        },poolExecutor).thenApply(f -> {
            return f+2;
        }).whenComplete((v,e) -> {
            if (e == null){
                System.out.println("-----result:"+v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        System.out.println("------------");
        System.out.println(future.join());
        System.out.println("============");

    }
}
