package com.feng.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @author
 * @time 2022/9/20 22:24
 * @Description- TODO
 */
public class CompletableFutureAPIDemo {

    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args) throws Exception {
//        api1();
//        api2();
//        api3();
//        api4();
        api5();
        poolExecutor.shutdown();
    }

    /**
     * 获得结果和触发计算
     */
    public static void api1() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        },poolExecutor);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(future.getNow(999)); //给个备胎
        System.out.println(future.complete(-1)+"\t" +future.get());
    }

    /**
     * exceptionally ---->try/catch
     * whenComplete \
     *               ---->try/finally
     * handle       /
     */
    public static void api2() {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).handle((f,e) ->{
            System.out.println(1/0);
            return f+2;
        }).handle((f,e) -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("----------"+v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        future.join();
    }

    /**
     * thenAccept():无输出
     * thenRun():无输入，无输出
     */
    public static void api3() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 1;
        }).thenAccept(f -> {
            System.out.println(f);
        });

        future.join();
    }
    /**
     * applyToEither():谁快用谁
     */
    public static void api4() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither( CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }),r -> {
            System.out.println(r);
            return r;
        });

        future.join();
    }

    /**
     * thenCombine():对计算结果进行合并
     */
    public static void api5() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            return 20;
        }),(r1,r2) -> {
            return r1 +r2;
        });

        System.out.println(future.join());
    }


}
