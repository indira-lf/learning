package com.feng.algorthm.other;

/**
 * @author
 * @time 2022/7/17 9:17
 * @Description- 异或运算
 *  题目1：
 *      怎么把一个int类型的数、提取出最右侧的1来
 *  例子：122对应的二进制为111 1010 最右侧的1在第二位
 *       155对应的二进制为1001 1011 最右侧的1在第1位
 *
 *  题目2：
 *      int类型的数，有几个1
 */
public class RightOne {
    public static void main(String[] args) {

        int rightOne = getRightOne(155);
        System.out.println(rightOne);

        int bit1Count = getBit1Count(155);
        System.out.println(bit1Count);
    }

    public static int getRightOne(int num){
        return num & ((~num)+1);
    }

    public static int getBit1Count(int num){

        int count = 0;
        while (num != 0){
            int rightOne = num & ((~num)+1);
            count++;
            //第一次 count=1
            //1001 1011 num
            //0000 0001 rightOne
            //1001 1010 new num
            //第二次 count=2
            //1001 1010 num
            //0000 0010 rightOne
            //1001 1000 new num
            num ^= rightOne;
        }
        return count;
    }
}
