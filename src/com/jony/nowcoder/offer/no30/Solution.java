/*
 * 题目：
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 思路：用两个数字来做标识，循环遍历
 */
package com.jony.nowcoder.offer.no30;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-31 00:15
 **/
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result = 0;
        if (array == null) {
            return result;
        }
        result = array[0];
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前中间结果还是正数，则和下一个数相加，因为此时还有可能和后续的数字组合变得更大
            temp = temp < 0 ? array[i] : array[i] + temp;
            // 如果中间结果已经比当前的结果大了，那么取中间结果作为最大值
            result = temp > result ? temp : result;
        }
        return result;
    }
}
