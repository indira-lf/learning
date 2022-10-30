package com.feng.algorthm.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author
 * @time 2022/10/30 8:02
 * @Description- 3、无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        int i = lengthOfLongestSubstring("abcabcbb");
//        int i = lengthOfLongestSubstring("bbbbb");
//        int i = lengthOfLongestSubstring("pwwkew");
        int i = lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen=0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++ ){
            if (map.containsKey(chars[i])){
                left = Math.max(left,map.get(chars[i]) + 1);
            }
            map.put(chars[i],i);
            maxLen = Math.max(maxLen,i-left+1);
        }

        return maxLen;
    }
}
