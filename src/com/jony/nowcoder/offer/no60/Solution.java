/**
 * 题目：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * <p>
 * 思路1：
 * 用两个队列分别保存相邻的两层
 * <p>
 * 思路2：
 * 用两个计数器分别保存当前层还有多少个元素，下一层有多少个元素
 */
package com.jony.nowcoder.offer.no60;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/13 23:21
 **/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue1.offer(pRoot);
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            ArrayList<Integer> list1 = getAll(queue1, queue2);
            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            ArrayList<Integer> list2 = getAll(queue2, queue1);
            if (!list2.isEmpty()) {
                lists.add(list2);
            }
        }
        return lists;
    }

    private ArrayList<Integer> getAll(Queue<TreeNode> queue1, Queue<TreeNode> queue2) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode tmp = queue1.poll();
            list.add(tmp.val);
            if (tmp.left != null) {
                queue2.add(tmp.left);
            }
            if (tmp.right != null) {
                queue2.add(tmp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(-1.5));
        System.out.println(Math.round(-1.51));
        System.out.println(Math.ceil(-1.5));

        System.out.println(Math.floor(1.5));
        System.out.println(Math.round(1.));
        System.out.println(Math.ceil(1.5));
    }
}
