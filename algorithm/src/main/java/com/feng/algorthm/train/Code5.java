package com.feng.algorthm.train;

/**
 * @author
 * @time 2022/10/23 4:15
 * @Description-
 * 给定一个正整数M，请构造一个长度为M的数组arr，要求对任意的i,j,k三个位置，
 * 如果i<j<k，都有arr[i]+arr[k] != 2*arr[j]
 * 返回构造出的arr
 */
public class Code5 {
    public static int[] makeNo(int size){
        if (size == 1){
            return new int[]{1};
        }

        int halfSize = (size +1)/2;
        int [] base = makeNo(halfSize);

        int[] ans = new int[size];
        int index = 0;

        for (;index<halfSize;index++){
            ans[index] = base[index] * 2 +1;
        }
        for (int i = 0;index <size;index++,i++){
            ans[index] = base[i] * 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = makeNo(5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
