package com.feng.algorthm.array;

/**
 * @author
 * @time 2022/7/18 22:53
 * @Description- 归并排序
 *  在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫组小和。求数组小和。
 *  例子：[1,3,4,2,5]
 *  1左边比1小的数：没有
 *  3左边比3小的数：1
 *  4左边比4小的数：1、3
 *  2左边比2小的数：1
 *  5左边比5小的数：1、3、4、2
 *  所以数组的小和为:1+1+3+1+1+3+4+2=16
 *
 *  左组<右组 产生小和，copy左组的数
 *  左组>=右组 不产生小和，copy右组的数
 *
 *
 */
public class MergeRank {

    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr,0,arr.length - 1);
    }

    /**
     * arr[L...R]范围上排好序，也要求小和返回
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int process(int[] arr, int l, int r) {
        if (l == r){
            return 0;
        }

        int mid = l + ((r - l) >> 1);

        return
                process(arr,l,mid)
                +
                process(arr,mid + 1,r)
                +
                merge(arr,l,mid,r);
    }

    private static int merge(int[] arr, int L, int m, int r) {

        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <=r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }

        return res;
    }
}
