/**
 * 题目：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 思路1：
 * 将数组排序，然后遍历，相同的元素肯定在一起
 * <p>
 * 思路2：
 * 遍历，将所有元素全部放入set，如果set里面已经有该元素，则从set删除
 * <p>
 * 思路3：
 * 考虑异或的性质，两个相同的数异或得到的是0，一个数和0的异或是它本身；
 * 遍历数组，所有数异或的结果是要找的两个数异或的结果；
 * 找到这个结果的二进制中第一个1所在的位，根据该位的值0或者1将数组分为两个数组，则要找的两个数被分在了不同的两个数组中；
 * 再分边异或这两个数组，最终得到的两个数便为所求
 */
package com.jony.nowcoder.offer.no40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/7 23:57
 **/
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Arrays.sort(array);
        int last = array[0];
        int count = 1;
        int found = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == last) {
                count++;
            } else {
                if (count == 1) {
                    if (found == 0) {
                        num1[0] = last;
                        found++;
                    } else {
                        num2[0] = last;
                        break;
                    }
                }
                last = array[i];
                count = 1;
            }
        }
        if (count == 1) {
            num2[0] = last;
        }
    }

    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();

        for (int value : array) {
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }
        Integer[] arr = set.toArray(new Integer[0]);
        num1[0] = arr[0];
        num2[0] = arr[1];
    }

    public void FindNumsAppearOnce3(int[] array, int num1[], int num2[]) {
        int temp = 0;
        for (int value : array) {
            temp ^= value;
        }
        int index = 0;
        while (((temp >> index) & 1) == 0) {
            index++;
        }
        for (int value : array) {
            if (((value >> index) & 1) == 0) {
                num1[0] = num1[0] ^ value;
            } else {
                num2[0] = num2[0] ^ value;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(4 >> 1);
    }
}
