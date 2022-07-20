package com.feng.jvm.stack;

/**
 * @author
 * @time 2022/7/20 20:28
 * @Description- TODO
 */
public class StringBuilderTest {
    /**
     * 线程安全
     */
    public static void method1() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
    }
    /**
     * 线程不安全
     */
    public static StringBuilder method2() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");

        return builder;
    }
    /**
     * 线程不安全
     */
    public static void method3(StringBuilder builder) {
        builder.append("a");
        builder.append("b");

    }
    /**
     * 线程安全
     */
    public static String method4() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");

        return builder.toString();
    }
}
