package com.feng.jvm.stack;

/**
 * @author
 * @time 2022/7/17 19:22
 * @Description- TODO
 */
public class DynamicLinkingTest {

    int num = 10;

    public void methodA(){
        System.out.println("methodA...");
    }

    public void methodB(){
        System.out.println("methodB...");
        methodA();

        num++;
    }
}
