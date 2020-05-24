/**
 * 题目：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 思路：
 * 维护两个指针，一个指向数组的第0个元素start，一个指向数组的最后一个元素end；
 * 如果两个数相加等于指定值，那么就找到所求，因为递增数组离的越远，乘积越小；
 * 如果相加大于指定值，则end--，否则start++
 */
package com.jony.nowcoder.offer.no42;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 16:49
 **/
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2) {
            return result;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start] + array[end];
            if (temp == sum) {
                result.add(array[start]);
                result.add(array[end]);
                break;
            } else if (temp < sum) {
                start++;
            }else {
                end--;
            }
        }
        return result;
    }
}
