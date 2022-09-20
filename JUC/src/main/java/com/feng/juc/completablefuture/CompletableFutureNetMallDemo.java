package com.feng.juc.completablefuture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author
 * @time 2022/9/20 21:18
 * @Description- 电商比价需求
 * 案例说明:
 *      1、同一款产品,同时搜索出同款产品在各大电商的售价;
 *      2、同一款产品,同时搜索出本产品在某一电商平台下，各个入驻门店的售价是多少
 *          出来结果希望是同款产品在不同的价格清单列表,返回一个List
 *              jd 88.05
 *              pdd 86.31
 *              taobao 90.43
 *
 *      3、要求:
 *          函数式编程
 *          链式编程
 *          Stream流式计算
 */
public class CompletableFutureNetMallDemo {

    public static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("pdd"),
            new NetMall("taobao"),
            new NetMall("tianmao"),
            new NetMall("dangdang")
    );

    //同步
    public static List<String> getPriceByStep(List<NetMall> list, String productName) {
        return list.stream().map(netMall ->
                String.format(productName + "in %s price is %.2f", netMall.getMallName(), netMall.calPrice(productName))
        ).collect(Collectors.toList());
    }

    //异步
    public static List<String> getPriceByAsync(List<NetMall> list, String productName) {
        return list.stream().map(netMall ->
                CompletableFuture.supplyAsync(() ->
                        String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calPrice(productName))))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<String> list1 = getPriceByStep(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start) + "毫秒");

        long startTime = System.currentTimeMillis();

        List<String> list2 = getPriceByAsync(list, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime - startTime) + "毫秒");
    }

}

class NetMall {
    private String mallName;

    public NetMall(String mallName) {
        this.mallName = mallName;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public double calPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
