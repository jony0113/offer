/**
 * 题目：
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 思路：
 * 1. 用两个栈保存一层的值，
 * 2. 第一个栈插入时，先插入右节点，再插入左节点
 * 3. 第二个栈插入时，先插入左节点，再插入右节点
 * 4. 遍历两个栈，第一个栈的子节点插入第二个栈，第二个栈的子节点插入第一个栈
 */
package com.jony.nowcoder.offer.no59;

import java.util.ArrayList;
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
 * @since 2020/3/13 22:56
 **/
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        // 先插入右节点，再插入左节点
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        // 先插入左节点，再插入右节点
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.empty() || !stack2.empty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode tmp = stack1.pop();
                list1.add(tmp.val);
                if (tmp.left != null) {
                    stack2.push(tmp.left);
                }
                if (tmp.right != null) {
                    stack2.push(tmp.right);
                }
            }
            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            ArrayList<Integer> list2 = new ArrayList<>();
            while (!stack2.empty()) {
                TreeNode tmp = stack2.pop();
                list2.add(tmp.val);
                if (tmp.right != null) {
                    stack1.push(tmp.right);
                }
                if (tmp.left != null) {
                    stack1.push(tmp.left);
                }
            }
            if (!list2.isEmpty()) {
                lists.add(list2);
            }
        }
        return lists;
    }
}
