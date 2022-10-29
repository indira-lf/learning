package com.feng.algorthm.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @time 2022/10/29 21:15
 * @Description- 1、两数之和
 */
public class TowSum {

    public static void main(String[] args) {
        //nums = [2,7,11,15], target = 9
//        int[] ints = towSum(new int[]{2, 7, 11, 13}, 9);
//        int[] ints2 = towSum(new int[]{3, 2, 4}, 6);
        int[] ints3 = towSum(new int[]{3, 3}, 6);
        for (int anInt : ints3) {
            System.out.println(anInt);
        }
    }

    /**
     * 方法1：暴力破解
     */
    public static int[] towSum1(int[] nums, int target){
        for (int i = 0; i< nums.length; i++){
            for (int j = i+1; j < nums.length;j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    /**
     * 方法2：hash表
     */
    public static int[] towSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();//K:nums[i];V:i
        for (int i = 0; i < nums.length; i++){
            System.out.println(map.toString());
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
