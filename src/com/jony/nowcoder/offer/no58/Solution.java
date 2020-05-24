/**
 * 题目：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * <p>
 * 思路：
 * 对根节点的左右子树进行层次遍历，左子树从左边开始，右子树从右边开始，遇到不相同的节点，结束
 */
package com.jony.nowcoder.offer.no58;

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
 * @since 2020/3/13 21:43
 **/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        Queue<TreeNode> leftQueue = new ArrayDeque<>();
        Queue<TreeNode> rightQueue = new ArrayDeque<>();
        leftQueue.add(left);
        rightQueue.add(right);
        boolean flag = true;
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode t1 = leftQueue.poll();
            TreeNode t2 = rightQueue.poll();
            if (t1 != null && t2 != null && t1.val == t2.val) {
                if (t1.left == null && t2.right != null || t1.left != null && t2.right == null
                        || t1.right == null && t2.left != null || t1.right != null && t2.left == null) {
                    flag = false;
                    break;
                }
                if (t1.left != null) {
                    leftQueue.add(t1.left);
                    rightQueue.add(t2.right);
                }
                if (t1.right != null && t2.left != null) {
                    leftQueue.add(t1.right);
                    rightQueue.add(t2.left);
                }

            } else {
                flag = false;
                break;
            }
        }
        if (flag && (!leftQueue.isEmpty() || !rightQueue.isEmpty())) {
            flag = false;
        }
        return flag;
    }
}
