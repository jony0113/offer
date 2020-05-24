/*
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 * 二叉搜索树的中序遍历是顺序的，用递归的办法中序遍历二叉树
 */
package com.jony.nowcoder.offer.no26;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-23 23:41
 **/
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            TreeNode head = Convert(pRootOfTree.left);
            TreeNode right = Convert(pRootOfTree.right);
            if (head == null) {
                head = pRootOfTree;
                pRootOfTree.left = null;
            } else {
                TreeNode left = head;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = pRootOfTree;
                pRootOfTree.left = left;
            }
            pRootOfTree.right = right;
            if (right != null) {
                right.left = pRootOfTree;
            }
            return head;
        }
    }
}
