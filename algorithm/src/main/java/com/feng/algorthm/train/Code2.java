package com.feng.algorthm.train;

import java.util.Stack;

/**
 * @author
 * @time 2022/10/16 9:40
 * @Description-
 * 括号有序配对是指：
 *  1) 任何一个左括号都能够找到和其正确配对的右括号
 *  2) 任何一个右括号都能找到和其正确配对的左括号
 *
 *  有效：((())) (()())
 *  无效：(() )(
 *  问题一：怎么判断一个括号字符串有效？
 *  问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 */
public class Code2 {

    public static void main(String[] args) {
        String str = "((()))))((";
        boolean valid3 = isValid(str);
        System.out.println(valid3);

        boolean valid = valid(str);
        System.out.println(valid);

    }

    public static boolean isValid(String s){
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++){
            if (str[i] == '('){
                stack.push(str[i]);
            }else if (stack.isEmpty()){
                return false;
            }else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        return true;
    }

    public static boolean valid(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++){
            count += str[i] == '('? 1 : -1;
            if (count<0){
                return false;
            }
        }
        return count==0;
    }
    public static int needParentheses(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < str.length; i++){
            if (str[i] == '('){
                count ++;
            }else {
                if (count == 0){
                    need++;
                }else {
                    count--;
                }
            }
        }
        return count+need;
    }
}
