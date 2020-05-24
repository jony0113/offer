/*
 * 题目：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：
 * 遍历压入序列，如果当前栈顶元素和弹出序列当前的元素相同，则弹出栈顶元素
 * 如果栈中有元素，则顺序弹出，如果弹出的元素和弹出序列中的当前元素不同，则返回false.
 */
package com.jony.nowcoder.offer.no21;

import java.util.Stack;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-17 23:32
 **/
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int length = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < length && j < length) {
            stack.push(pushA[i++]);
            if (popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        while (!stack.isEmpty()) {
            if (popA[j++] != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
