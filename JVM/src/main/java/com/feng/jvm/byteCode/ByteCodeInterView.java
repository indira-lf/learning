package com.feng.jvm.byteCode;

import org.junit.Test;

/**
 * @author
 * @time 2022/7/30 10:35
 * @Description- TODO
 */
public class ByteCodeInterView {
    // i++和++i有什么区别？
    // 字节码层面相同
    @Test
    public void test1(){
        int i = 10;
        i++;
//        ++i;
        System.out.println(i);
    }
    @Test
    public void test2(){
        int i = 10;
        i = i++;
        /**
         *          局部变量表   操作数栈
         * 第一步：                 10
         * 第二步：     10          10
         * 第三步：     11          10
         * 第四步：     10              ---->11被覆盖
         * 打印：10
         */
        System.out.println(i);
    }
    @Test
    public void test3(){
        int i = 10;
        i *= i++; // i = i * i++
        System.out.println(i);
    }
    @Test
    public void test4(){
        int i = 10;
        i = i + (i++) + (++i);
        System.out.println(i);
    }
    @Test
    public void test5(){
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);

        Integer i3 = 128; //Integer -128~127
        Integer i4 = 128;
        System.out.println(i3 == i4);

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);
    }

    @Test
    public void test6(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /*
            如下s1+s2细节：
            第一步：StringBuilder s = new StringBuilder();
            第二步：s.append("a");
            第三步：s.append("b");
            第四步：s.toString(); --->约等于new String("ab");

            补充：jdk5以后用的是StringBuilder,在jdk5以前用的是StringBuffer
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4); //false
    }

    /**
     * 1、字符串拼接操作不一定使用的是StringBuilder！
     *      如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式
     * 2、针对final修饰的类、方法、基本数据类型、引用数据类型的量的结构时，能使用上final的时候建议使用上
     */
    @Test
    public void test7(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4); //true
    }

    /**
     * 执行效率:
     *  ① StringBuilder的append()的方式：自始至终只创建了过一个StringBuilder的对象
     *      使用String的字符串拼接方式：创建过多个StringBuilder和String对象
     *  ② 使用String的字符串拼接方式：内存中由于创建了较多的StringBuilder和String对象，内存占用更大，如果进行GC，需要花费额外的时间
     *
     *  method2的改进空间：在实际开发中，如果基本确定要前前后后添加的字符串长度不高于某个限定值highLevel的情况下，建议使用构造器指定容量
     */
    @Test
    public void test8(){
        long time1 = System.currentTimeMillis();
        method1(100000); //4577
        long time2 = System.currentTimeMillis();
        method2(100000); //16
        long time3 = System.currentTimeMillis();
        System.out.println("mathod1:"+(time2-time1));
        System.out.println("mathod2:"+(time3-time2));
    }

    private void method1(int highLevel) {
        String src = "";
        for (int i=0; i<highLevel; i++){
            src += "a"; //每次循环都会创建一个StringBuilder、String
        }
    }

    private void method2(int highLevel) {
        StringBuilder src = new StringBuilder();
        for (int i=0; i<highLevel; i++){
            src.append("a");
        }
        //src.toString();
    }

    /**
     * new String("ab);会创建几个对象
     *      两个
     */
    @Test
    public void test9(){
        String ab = new String("ab");
        /**
         * 对象1：new StringBuilder()
         * 对象2：new String("a")
         * 对象3：常量池中的"a"
         * 对象4：new String("b")
         * 对象5：常量池中的"b"
         *
         * 深入剖析：StringBuilder的toString()
         *  对象6：new String("ab");
         *      toString()的调用在字符串常量池中，没有生成"ab"
         */
        String str = new String("a") + new String("b");
    }

    @Test
    public void test10(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4); //false
    }

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4); //true
    }
}
