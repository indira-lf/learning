package com.feng.algorthm.huadongchuangkou;

import java.util.LinkedList;

/**
 * @author
 * @time 2022/10/4 14:07
 * @Description- 假设一个固定大小为W的窗口，依次划过arr，返回每一次滑出状况的最大值
 *  例如，arr = [4,3,5,4,3,3,6,7],W=3
 *      返回：[5,5,5,4,6,7]
 */
public class demo1 {

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int i : maxWindow) {
            System.out.println(i);
        }

    }

    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w<1 || arr.length<w){
            return null;
        }

        //双端队列 头->尾(大->小) 存放数组下标
        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for (int r=0; r<arr.length; r++){
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[r]){
                queue.pollLast();
            }
            queue.addLast(r);

            //判断头部下标是否是过期下标(后面进来的下标必定大于头部的下标)
            if (queue.peekFirst() == r-w){
                queue.pollFirst();
            }

            //形成窗口前不收集答案
            if (r >= w-1){
                res[index++] = arr[queue.peekFirst()];
            }
        }

        return res;
    }
}
