/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路：
 * 1. 如果存在右孩子，找右孩子下最左边的孩子
 * 2. 如果不存在右孩子，找第一个左孩子是当前节点的父系节点的节点，否则就没有后继结点
 */
package com.jony.nowcoder.offer.no57;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/12 23:56
 **/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 右子树不为空，则找右子树最左边的孩子
        if (pNode.right != null) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        TreeLinkNode temp = pNode;
        while (temp.next != null) {
            if (temp.next.left == temp) {
                return temp.next;
            }
            temp = temp.next;
        }
        return null;
    }
}
