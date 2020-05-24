/**
 * 题目：
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过
 * 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * <p>
 * 思路：
 * 广度优先遍历，需要将每一层都元素都铺满；
 */
package com.jony.nowcoder.offer.no61;

import java.util.ArrayDeque;
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
 * @since 2020/3/14 22:00
 **/
public class Solution {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode nullNode = new TreeNode(Integer.MAX_VALUE);
        // 记录下一层是否还有非空节点
        boolean hasMore = true;
        // 记录当前层有多少个节点
        int nodes = 1;
        // 记录当前层还剩下多少个节点
        int left = 1;
        do {
            // 开始遍历某一层时，重置是否遍历下一层
            if (left == nodes) {
                hasMore = false;
            }
            left--;
            TreeNode tmp = queue.poll();
            if (tmp == nullNode) {
                res.append("#!");
                queue.offer(nullNode);
                queue.offer(nullNode);
            } else {
                res.append(tmp.val).append("!");
                if (tmp.left != null || tmp.right != null) {
                    hasMore = true;
                    queue.offer(tmp.left == null ? nullNode : tmp.left);
                    queue.offer(tmp.right == null ? nullNode : tmp.right);
                }
            }
            if (left == 0 && hasMore) {
                nodes *= 2;
                left = nodes;
            }
        } while (left > 0 || hasMore);
        return res.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] arr = str.split("!");
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if ("#".equals(arr[i])) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] != null) {
                int a = 2 * i + 1;
                int b = 2 * i + 2;
                if (a < arr.length && nodes[a] != null) {
                    nodes[i].left = nodes[a];
                }
                if (b < arr.length && nodes[b] != null) {
                    nodes[i].right = nodes[b];
                }
            }
        }
        return nodes[0];
    }
}
