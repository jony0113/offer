/*
 * 题目：
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：
 * 把一个整数减去一，再与原整数做与运算，会把该整数最右边的一变为零，则一个二进制中有多少个一就可以进行多少次操作
 */
package com.jony.nowcoder.offer.no11;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-08 23:38
 **/
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
