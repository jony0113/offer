/*
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：用一个栈stack存储，另一个栈min放入当前最小的元素，
 * push：只有当要push的元素小于等于最小栈顶的元素时，才push最小栈
 * pop：只有当pop的元素等于最小栈顶的元素时，最小栈才pop
 *
 */
package com.jony.nowcoder.offer.no20;

import java.util.Stack;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-17 00:26
 **/
public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || min() >= node) {
            min.push(node);
        }
    }

    public void pop() {
        int node = stack.pop();
        if (node == min()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
