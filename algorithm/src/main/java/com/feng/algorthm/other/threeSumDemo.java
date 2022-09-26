package com.feng.algorthm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @time 2022/9/26 22:12
 * @Description- 三数之和
 */
public class threeSumDemo {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int len = nums.length;

        for (int i=0; i<len; i++){
            if (i>0 && nums[i-1] == nums[i]){
                continue;
            }

            int right = len - 1;
            int target = - nums[i];
            for (int j=i+1; j<len; j++) {
                if (j> i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                while (j<right && nums[j]+nums[right]>target){
                    right--;
                }
                if (j==right){
                    break;
                }
                if (nums[j]+nums[right] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[right]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}
