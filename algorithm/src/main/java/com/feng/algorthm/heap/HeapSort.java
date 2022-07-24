package com.feng.algorthm.heap;

import java.util.Arrays;

/**
 * @author
 * @time 2022/7/24 18:53
 * @Description- 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,5,5};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }

        for (int i = arr.length-1; i>=0; i--){
            heapify(arr,i,arr.length);
        }
//        int heapSize = arr.length;
//        swap(arr,0,--heapSize);
//        while (heapSize > 0){
//            heapify(arr,0,heapSize);
//            swap(arr,0,--heapSize);
//        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
//            int largest = left + 1 < heapSize && arr[left +1]>arr[left] ? left + 1:left;
            int largest;
            if (left+1<heapSize){
                largest = arr[left +1]>arr[left] ? left + 1:left;
            } else {
                largest = arr[index] > arr[left]?index:left;
            }
            largest = arr[largest] > arr[index]?largest:index;
            if (largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int index, int heapSize) {
        int temp = arr[index];
        arr[index] = arr[heapSize];
        arr[heapSize] = temp;
    }
}
