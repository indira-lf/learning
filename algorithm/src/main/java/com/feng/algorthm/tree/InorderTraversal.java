package com.feng.algorthm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 @author
 @time 2022/8/7 10:02
 @Description- 二叉树非递归遍历
 */
public class InorderTraversal {

    /**
     * 前序遍历
     * @param head
     */
    public static void pre(TreeNode head) {
        System.out.println("pre-order:");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }

            System.out.println();
        }
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void in (TreeNode head) {
        System.out.println("in-order:");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后续遍历
     * @param head
     */
    public static void pos(TreeNode head) {
        System.out.println("pos-order:");
        if (head == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if (temp.left != null && head != temp.left && head != temp.right) { //加head != temp.left && head != temp.right条件就是确保左子树已经处理完了
                stack.push(temp.left);
            } else if (temp.right != null && head != temp.right) { //加head != temp.right是确保右子树处理完了
                stack.push(temp.right);
            } else {
                System.out.println(stack.pop().val + "");
                head = temp;
            }
        }

        System.out.println();
    }

    /**
     * 层次遍历
     * @param head
     */
    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
