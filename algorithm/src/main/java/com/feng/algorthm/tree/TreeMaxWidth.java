package com.feng.algorthm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author
 * @time 2022/8/7 15:03
 * @Description- 二叉树最大的宽度
 */
public class TreeMaxWidth {
    public static int maxWidthUserMap(TreeNode head) {
        if (head == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null){
                levelMap.put(cur.left,curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right != null){
                levelMap.put(cur.right,curNodeLevel+1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel){
                curLevelNodes++;
            }else {
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max,curLevelNodes);
        return max;
    }

    public static int maxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        TreeNode curEnd = head;
        TreeNode nextEnd = null;

        int max= 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;

            if (cur == curEnd) {
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
