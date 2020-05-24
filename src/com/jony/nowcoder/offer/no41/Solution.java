/**
 * 题目：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * <p>
 * 思路：
 * 维护两个指针，分别标识连续序列的起始范围，计算和的公式为(a0+an)*n/2
 * 如果和大于给定的数，则结束指针向前移，否则开始指针向后移
 */
package com.jony.nowcoder.offer.no41;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 15:59
 **/
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) {
            return result;
        }
        int start = 1, end = 2;
        while (start < end) {
            int temp = (start + end) * (end - start + 1) / 2;
            if (sum == temp) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
                start++;
            } else if (temp < sum) {
                end++;
            } else {
                start++;
            }
        }
        return result;
    }
}
