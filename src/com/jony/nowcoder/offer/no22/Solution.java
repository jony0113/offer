/*
 * 题目：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：
 * 广度优先，使用队列
 */
package com.jony.nowcoder.offer.no22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-18 00:34
 **/
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            arrayList.add(temp.val);
        }
        return arrayList;
    }
}
