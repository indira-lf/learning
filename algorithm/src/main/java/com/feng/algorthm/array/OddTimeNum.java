package com.feng.algorthm.array;

import java.util.Arrays;

/**
 * @author
 * @time 2022/7/17 8:58
 * @Description- 异或运算
 *  题目1：
 *      一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 *  题目2：
 *      一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 */
public class OddTimeNum {

    public static void main(String[] args) {
        OddTimeNum oddTimeNum = new OddTimeNum();

        oddTimeNum.eor(1,2);

        int[] nums = {1,2,3,4,1,2,3,4,6,5,6,5,7,7,7};
        int num = oddTimeNum.printOddTimeNum(nums);
        System.out.println(num);

        int[] nums2 = {1,2,3,4,1,2,3,4,6,5,6,5,7,7,7,8};
        int[] ints = oddTimeNum.printOddTimeNum2(nums2);
        System.out.println(Arrays.toString(ints));

    }

    public void eor(int a, int b){
        int eor = 0;
        eor = a ^ b;
        int temp = eor ^ b;
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("temp="+temp);
    }
    /**
     * 题目一：一个奇数
     * @param nums
     * @return
     */
    public int printOddTimeNum(int[] nums){
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    /**
     * 题目二：出现两个奇数a、b
     * @param nums
     * @return
     */
    public int[] printOddTimeNum2(int[] nums){
        int[] eor = new int[2];
        for (int num : nums) {
            // eor[0] = a ^ b
            eor[0] = eor[0] ^ num;
        }
        //获取最右侧1的位置
        int rightOne = eor[0] & ((~ eor[0])+1);

        //获取最左侧1的位置和rightOne相等的元素
        int temps[] = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            //方法一
            if (rightOne == (num&(~num)+1)){
                temps[index] = num;
                index++;
            }
            //方法二
            /*if ((num & rightOne) != 0){
                temps[index] = num;
                index++;
            }*/
        }

        for (int temp : temps) {
            //获得的eor2是a或者b
            eor[1] = eor[1] ^ temp;
        }

        //eor为a或者b
        eor[0] = eor[0] ^ eor[1];

        return eor;
    }
}
