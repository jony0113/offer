/**
 * 题目：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * <p>
 * 思路：
 * 使用循环的方式获得中序遍历的结果，如果list的大小符合，直接返回
 */
package com.jony.nowcoder.offer.no62;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * @since 2020/3/14 23:01
 **/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur);
            if (list.size() == k) {
                break;
            }
            cur = cur.right;
        }
        if (list.size() < k) {
            return null;
        }
        return list.get(k - 1);
    }
}
