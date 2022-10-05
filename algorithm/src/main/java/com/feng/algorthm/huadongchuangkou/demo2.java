package com.feng.algorthm.huadongchuangkou;

import java.util.LinkedList;

/**
 * @author
 * @time 2022/10/4 15:00
 * @Description- 给定一个整型数组arr,和一个整数num
 *              某个arr中的子数组sub,如果想达标,必须满足:
 *              sub中最大值-sub中最小值 <= num;
 *              返回arr中达标子数组的数量
 */
public class demo2 {

    public static void main(String[] args) {
        int subCount = getSubCount(new int[]{1, 2, 3,4}, 3);
        System.out.println(subCount);
    }

    public static int getSubCount(int[] arr,int num){
        int count = 0,l=0,r=0;

        LinkedList<Integer> queueMin = new LinkedList<>();
        LinkedList<Integer> queueMax = new LinkedList<>();

        while (l < arr.length) {
            while (r < arr.length){
                while (!queueMin.isEmpty() && arr[queueMin.peekLast()] >= arr[r]) {
                    queueMin.pollLast();
                }
                queueMin.addLast(r);
                while (!queueMax.isEmpty() && arr[queueMax.peekLast()]<=arr[r]) {
                    queueMax.pollLast();
                }
                queueMax.addLast(r);

                if (arr[queueMax.peekFirst()] - arr[queueMin.peekFirst()] > num){
                    break;
                }
                r++;
            }

            count += r-l;
            if (queueMin.peekFirst() == l){
                queueMin.pollFirst();
            }
            if (queueMax.peekFirst() == l){
                queueMax.pollFirst();
            }

            l++;
        }

        return count;
    }
}
