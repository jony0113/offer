/**
 * 题目：
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 思路：
 * 1. 递归写法，左子树和右子树较大的+1
 * <p>
 * 2. 广度优先遍历，每遍历完1层+1
 */
package com.jony.nowcoder.offer.no38;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
 * @since 2020/3/6 22:44
 **/
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.add(treeNode.left);
                next++;
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
                next++;
            }
            cur--;
            if (cur == 0) {
                depth++;
                cur = next;
                next = 0;
            }
        }
        return depth;
    }

    // 广度优先遍历
    public List<Integer> BFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return list;
    }

    //先根遍历
    public List<Integer> preNode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }

    // 中根遍历
    public List<Integer> inNode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    // 后根遍历
    public List<Integer> postNode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 上一个输出的节点
        TreeNode last = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();

            // 右孩子为null，说明到达叶子节点；
            // 右孩子是上次输出的节点，证明上次输出的是当前节点的右孩子，则本次应该输出当前节点
            if (temp.right == null || temp.right == last) {
                list.add(temp.val);
                last = temp;
            }
            // 否则遍历右子树
            else {
                stack.push(temp);
                cur = temp.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution solution = new Solution();
        System.out.println(solution.BFS(t1));
        System.out.println(solution.preNode(t1));
        System.out.println(solution.inNode(t1));
        System.out.println(solution.postNode(t1));
    }
}
