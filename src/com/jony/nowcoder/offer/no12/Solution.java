/*
 * 题目：
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路：
 * 如果base为0(减0得到一个极小的数)，返回0
 * 如果exponent为0，返回1
 * 如果
 *
 */
package com.jony.nowcoder.offer.no12;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-09 00:07
 **/
public class Solution {
    public double Power(double base, int exponent) {
        if (base - 0 < 0.00000001 && 0 - base < 0.00000001) {
            return 0;
        }
        if (exponent < 0) {
            return 1 / pow(base, -exponent);
        } else {
            return pow(base, exponent);
        }
    }

    private double pow(double base, int exp) {
        double result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        return result;
    }
}
