/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 * <p>
 * 思路一：
 * 遍历，利用set存储
 * <p>
 * 思路二：
 * 重点在于数字的值都在0到n-1之间，恰好是数组下标的范围
 * 1. 遍历数组，如果数值和下标相同，则继续遍历
 * 2. 若不相同
 * 2.1 先判断已该值为下标的数组元素是否等于该值，若相等，表明找到重复元素
 * 2.2 若不想等，则交换两者的位置，
 */
package com.jony.nowcoder.offer.no50;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/10 21:37
 **/
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using
    //    duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length != length || length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
                break;
            } else {
                set.add(numbers[i]);
            }
        }
        return flag;
    }

    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length != length || length < 2) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    flag = true;
                    break;
                } else {
                    int tmp = numbers[i];
                    numbers[i] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
            if (flag){
                break;
            }
        }
        return flag;
    }

}
