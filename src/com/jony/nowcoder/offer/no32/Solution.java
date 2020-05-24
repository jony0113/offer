/*
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 *
 * 思路：
 * 重点在于如何排序，将两个数连接起来的结果进行比较
 * ab > ba => a>b
 * ab == ba => a=b
 * ab < ba => a<b
 */
package com.jony.nowcoder.offer.no32;

import java.util.Arrays;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-13 17:02
 **/
public class Solution {
    public String printMinNumber(int[] numbers) {
        if (numbers == null) {
            return "";
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, (n1, n2) -> {
            String n1n2 = String.valueOf(n1).concat(String.valueOf(n2));
            String n2n1 = String.valueOf(n2).concat(String.valueOf(n1));
            return n1n2.compareTo(n2n1);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : nums) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }

}
