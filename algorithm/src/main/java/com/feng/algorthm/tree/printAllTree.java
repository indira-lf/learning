package com.feng.algorthm.tree;

/**
 * @author
 * @time 2022/8/19 22:35
 * @Description- 打印整颗数的函数
 */
public class printAllTree {
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right,height+1,"v",len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM)/2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left,height+1,"^",len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
