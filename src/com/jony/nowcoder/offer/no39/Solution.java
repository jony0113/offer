/**
 * 题目：
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树的性质：要么是一棵空树，要么左右子树高度差不超过1，并且左右子树都是平衡二叉树
 */
package com.jony.nowcoder.offer.no39;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/7 23:13
 **/
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return root == null
                || (root.left == null && root.right == null)
                || (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
                            && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);
    }

    /**
     * 获取某个节点的高度
     *
     * @param root
     *
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
