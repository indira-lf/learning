package com.feng.jvm.heap;

/**
 * @author
 * @time 2022/7/20 22:22
 * @Description- TODO
 */
public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My id is"+id);
    }

    public static void main(String[] args) {
        SimpleHeap simpleHeap1 = new SimpleHeap(1);
        SimpleHeap simpleHeap2 = new SimpleHeap(1);
    }
}
