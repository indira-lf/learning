package com.feng.jvm.methodArea;

/**
 * @author
 * @time 2022/7/24 8:44
 * @Description- TODO
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        order.hello();
        System.out.println(order.count);
    }
}

class Order {
    public static int count = 1;
    public static final int number = 2;

    public static void hello(){
        System.out.println("hello...");
    }
}