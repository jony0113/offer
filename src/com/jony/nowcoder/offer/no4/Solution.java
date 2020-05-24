/*
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：
 * 使用递归的方法，前序遍历的第一个元素是根节点，在中序遍历序列中找到这个元素，然后可以找到左孩子和右孩子的个数，递归调用
 */
package com.jony.nowcoder.offer.no4;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-02 23:45
 **/
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length < 1 || pre.length != in.length) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);
        int count = findCountOfIn(in, inStart, inEnd, pre[preStart]);
        treeNode.left = reConstructBinaryTree(pre, preStart + 1, preStart + count, in, inStart, inStart + count - 1);
        treeNode.right = reConstructBinaryTree(pre, preStart + count + 1, preEnd, in, inStart + count + 1, inEnd);
        return treeNode;
    }

    private int findCountOfIn(int[] arr, int start, int end, int num) {
        int i = start;
        for (; i <= end; i++) {
            if (arr[i] == num) {
                break;
            }
        }
        return i - start;
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] end = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode treeNode = new Solution().reConstructBinaryTree(pre, end);
    }
}
