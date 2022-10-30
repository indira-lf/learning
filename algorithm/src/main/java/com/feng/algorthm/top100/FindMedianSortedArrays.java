package com.feng.algorthm.top100;

/**
 * @author
 * @time 2022/10/30 8:30
 * @Description- 4、寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        double arrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(arrays);
    }

    /**
     * 方法2
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < len1 && (bStart >= len2 || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }

    /**
     * 方法1
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int len1 = nums1.length,len2 = nums2.length;
        int[] newArray = new int[len1+len2];
        int count = len1 + len2;
        int index = 0;

        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0;
            } else {

                return nums2[len2 / 2];
            }
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0;
            } else {
                return nums1[len1 / 2];
            }
        }

        while (index != count){

            if (i == len1) {
                while (j != len2) {
                    newArray[index++] = nums2[j++];
                }
                break;
            }
            if (j == len2) {
                while (i != len1) {
                    newArray[index++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] <= nums2[j]){
                newArray[index++] = nums1[i++];
            }else {
                newArray[index++] = nums2[j++];
            }

        }

        int temp = (len1 + len2)%2;
        double min = temp==0?(newArray[count/2 - 1]+newArray[count/2])/2.0:newArray[count/2];

        return min;
    }
}
