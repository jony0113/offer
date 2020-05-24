/*
 * 题目:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路:
 * stack1用来临时存储，stack2用来将元素的先后顺序进行倒置
 */
package com.jony.nowcoder.offer.no5;

import java.util.Stack;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-04 23:42
 **/
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack2.push(node);
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
