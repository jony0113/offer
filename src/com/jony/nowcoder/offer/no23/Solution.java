/*
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：
 * 递归
 * 如果去掉最后一个元素，将剩余序列分为前后两段，前面的比最后一个元素小，后面的比最后一个元素大，
 * 这两段分别为二叉搜索数的后续遍历序列,则说明是BST的后续遍历序列
 */
package com.jony.nowcoder.offer.no23;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-18 23:30
 **/
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 1) {
            return true;
        }
        if (sequence.length == 0) {
            return false;
        }
        return isBSTSequence(sequence, 0, sequence.length - 1);
    }

    private boolean isBSTSequence(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int index = start;
        while (index <= end && sequence[index] < sequence[end]) {
            index++;
        }
        for (int i = index; i < end - 1; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return isBSTSequence(sequence, start, index - 1) && isBSTSequence(sequence, index, end - 1);
    }
}
