/*
 * 题目：
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 思路：
 * 动态规划
 */
package com.jony.nowcoder.offer.no7;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-06 00:05
 **/
public class Solution {
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
