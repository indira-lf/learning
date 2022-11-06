package com.feng.algorthm.top100;

import java.util.ArrayList;

/**
 * @author
 * @time 2022/11/5 9:56
 * @Description-  6、Z 字形变换
 */
public class ConvertZ {

    public static void main(String[] args) {
        String convert = convert("PAYPALISHIRING", 3);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i <numRows; i++) list.add(new StringBuilder(0));
        int i=0,flag = -1;

        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder builder = new StringBuilder(s.length());
        for (StringBuilder ele : list) {
            builder.append(ele);
        }

        return builder.toString();
    }
}
