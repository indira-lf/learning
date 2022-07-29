package com.feng.jvm.stringTable;

/**
 * @author
 * @time 2022/7/29 20:38
 * @Description- TODO
 */
public class StringTest1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("1");//2327
        System.out.println("2");//2328
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2336

        System.out.println("1"); //2336
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");
    }
}
