package com.feng.algorthm.train;

/**
 * @author
 * @time 2022/10/16 9:20
 * @Description-
 *  给定一个有序数组arr，从左到右依次表示x轴上从左往右点的位置，
 *  给定一个正整数k，返回如果有一根铲毒为k的绳子，最多能盖住几个点
 *  绳子的边缘点碰到X轴上的点，也算覆盖住
 */
public class Code1 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,5,7,9};

        maxPoint(arr,4);
    }

    public static int maxPoint(int[] arr,int k){

        int left = 0;
        int right = 0;
        int len = arr.length;
        int count = 0;

        while (left<len){
            while (right < len && arr[right]-arr[left]<=k){
                right++;
            }
            count = Math.max(count,right - (left++));
        }
        System.out.println(count);
        return count;
    }
}
