package com.feng.jvm.stack;

import java.util.Date;

/**
 * @author
 * @time 2022/7/17 14:21
 * @Description- TODO
 */
public class LocalVariableTest {
    int count = 0;
    public static void main(String[] args) {

    }

    public LocalVariableTest(){
        this.count = 1;
    }

    public void test1(){
        Date date = new Date();
        String name1 = "feng";
        test2(date,name1);
        System.out.println(date+name1);
    }

    private String test2(Date date, String name2) {
        date = null;
        name2 = "fengPlus";
        double weight = 130.5;
        char gender = '男';
        return date+name2;
    }

    public void test3() {
        this.count++;
    }

    /**
     * Slot槽重复利用问题
     */
    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b的位置
        int c = a + 1;
    }
}
