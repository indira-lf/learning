package com.feng.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @time 2022/9/21 21:47
 * @Description- 题目:谈谈你对多线程的理解
 * 1、标准访问有ab两个线程，请问先打印邮件还是短信 --->lock1()
 * 2、sendEmail方法暂停3s，请问先打印邮件还是短信 --->lock2()
 * 3、新增一个普通的hello方法，请问先打印邮件还是hello --->lock3()
 * 4、有两部手机，请问先打印邮件还是短信 --->lock4()
 * 5、两个静态同步方法，同一部手机，请问先打印邮件还是短信 --->lock5()
 * 6、两个静态同步方法，一部手机，请问先打印邮件还是短信 --->lock6()
 * 7、一个静态同步方法，一个同步方法，同一部手机，请问先打印邮件还是短信 --->lock7()
 * 8、一个静态同步方法，一个同步方法，同两部手机，请问先打印邮件还是短信 --->lock8()
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
//        lock1(phone);
//        lock2(phone);
//        lock3(phone);
//        lock4(phone,phone2);
//        lock5(phone);
//        lock6(phone,phone2);
//        lock7(phone);
        lock8(phone,phone2);
    }

    private static void lock1(Phone phone) {
        new Thread(() -> {
            phone.sendEmail1();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendSMS();
        },"BB").start();
    }
    private static void lock2(Phone phone) {
        new Thread(() -> {
            phone.sendEmail();
        },"AA").start();


        new Thread(() -> {
            phone.sendSMS();
        },"BB").start();
    }
    private static void lock3(Phone phone) {
        new Thread(() -> {
            phone.sendEmail();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.hello();
        },"BB").start();
    }
    private static void lock4(Phone phone1,Phone phone2) {
        new Thread(() -> {
            phone1.sendEmail();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.hello();
        },"BB").start();
    }
    private static void lock5(Phone phone) {
        new Thread(() -> {
            phone.sendEmail5();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendSMS5();
        },"BB").start();
    }
    private static void lock6(Phone phone1,Phone phone2) {
        new Thread(() -> {
            phone1.sendEmail5();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendSMS5();
        },"BB").start();
    }
    private static void lock7(Phone phone) {
        new Thread(() -> {
            phone.sendEmail7();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendSMS7();
        },"BB").start();
    }
    private static void lock8(Phone phone1,Phone phone2) {
        new Thread(() -> {
            phone1.sendEmail7();
        },"AA").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendSMS7();
        },"BB").start();
    }
}


class Phone {

    public synchronized void sendEmail1() {
        System.out.println("-----------sendEmail");
    }
    public synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("-----------sendSMS");
    }

    /**
     * lock5()
     */
    public static synchronized void sendEmail5() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------sendEmail");
    }
    /**
     * lock5()
     */
    public static synchronized void sendSMS5() {
        System.out.println("-----------sendSMS");
    }
    /**
     * lock7()
     */
    public static synchronized void sendEmail7() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------sendEmail");
    }
    /**
     * lock7()
     */
    public synchronized void sendSMS7() {
        System.out.println("-----------sendSMS");
    }

    public void hello() {
        System.out.println("hello lock3");
    }
}