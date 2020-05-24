/*
 * 题目：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 思路：
 * 按照深度优先（前序遍历）来遍历整个树
 * 1. 非递归的方法，使用两个栈，一个记录还没遍历的元素，一个记录已经遍历的元素，以便能够知道何时舍弃上一个元素
 * 2. 递归的方法，
 */
package com.jony.nowcoder.offer.no24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-19 23:35
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

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null || root.val > target) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            // stack中的栈顶元素不是上一个元素，则需要回退一个元素
            if (!nodes.isEmpty() && nodes.peek().left != treeNode && nodes.peek().right != treeNode) {
                int last = arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                nodes.pop();
                sum -= last;
            } else {
                stack.pop();
                int temp = sum + treeNode.val;
                if (temp <= target) {
                    sum = temp;
                    arrayList.add(treeNode.val);
                    nodes.push(treeNode);
                    if (temp < target) {
                        if (treeNode.left != null) {
                            stack.push(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            stack.push(treeNode.right);
                        }
                    }
                    // 只有当当前元素是叶子节点，并且加和等于target，才算一条完整的路径
                    else if (treeNode.left == null && treeNode.right == null) {
                        ArrayList<Integer> list = new ArrayList<>(arrayList);
                        result.add(list);
                    }
                }
            }
        }
        result.sort(Comparator.comparing(ArrayList::size, Comparator.reverseOrder()));
        return result;
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if (root == null || root.val > target) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        } else {
            FindPath1(root.left, target);
            FindPath1(root.right, target);
        }
        list.remove(list.size()-1);
        return result;
    }
}
