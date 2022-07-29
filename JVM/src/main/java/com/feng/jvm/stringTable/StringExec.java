package com.feng.jvm.stringTable;

/**
 * @author
 * @time 2022/7/28 21:16
 * @Description- TODO
 */
public class StringExec {
    String str = "good";
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[]) {
        str = "task ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExec ex = new StringExec();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
}
