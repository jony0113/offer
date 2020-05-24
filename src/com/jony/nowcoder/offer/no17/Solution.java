/*
 * 题目：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：
 * 子结构的意思是只要结构上相同就行，不是子树的概念
 * 使用递归的方法，判断当前树是否含有子结构，以及左子树、右子树是否含有子结构
 */
package com.jony.nowcoder.offer.no17;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-12 00:38
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

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return has(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean has(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return root1.val == root2.val && has(root1.left, root2.left) && has(root1.right, root2.right);
    }

}
