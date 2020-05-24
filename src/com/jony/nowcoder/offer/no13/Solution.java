/*
 * 题目：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：
 * 1. 原址移动，遍历，如果遇到偶数则顺序交换直到把该数移动到数组的最后一个位置
 * 2. 新建数组，存放偶数，并将奇数往前移动，最后把偶数拷贝到原数组
 */
package com.jony.nowcoder.offer.no13;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-10 00:40
 **/
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        // method1(array);
        method2(array);
    }

    private void method1(int[] array) {
        int evenCount = 0;
        for (int i = 0; i + evenCount < array.length; ) {
            if ((array[i] & 1) != 1) {
                evenCount++;
                for (int j = i + 1; j < array.length; j++) {
                    // swap
                    array[j - 1] += array[j];
                    array[j] = array[j - 1] - array[j];
                    array[j - 1] = array[j - 1] - array[j];
                }
            } else {
                i++;
            }
        }
    }

    private void method2(int[] array) {
        int oddCount = 0;
        int evenCount = 0;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 1) {
                temp[evenCount++] = array[i];
            } else {
                if (oddCount < i) {
                    array[oddCount] = array[i];
                }
                oddCount++;
            }
        }
        if (oddCount < array.length) {
            System.arraycopy(temp,0,array,oddCount,evenCount);
        }
    }

}
