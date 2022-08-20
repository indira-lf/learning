package com.feng.algorthm.tree;

/**
 * @author
 * @time 2022/8/20 15:30
 * @Description- 给定一颗二叉树的头结点head，返回这颗二叉树是不是平衡二叉树
 */
public class BalanceTree {

    /**
     * 左、右要求一样，info信息返回的结构体
     */
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info (boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isBalance = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height- rightInfo.height)>1){
            isBalance = false;
        }
        return new Info(isBalance,height);
    }
}
