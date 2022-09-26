package com.feng.algorthm.other;

import java.util.HashMap;

/**
 * @author
 * @time 2022/9/26 20:26
 * @Description- 无重复字符的最长子串
 *      给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();
        int i = substring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int len = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            len = Math.max(len,i-left+1);
        }

        return len;
    }
}
