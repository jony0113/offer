/*
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * 思路1：
 * 1. 将数组排序
 * 2. 取中间那个元素，则如果存在这样的数字，则一定是中间那个数字
 * 3. 分别从中间那个元素向前、向后遍历，直到不再等于中间那个数字，最后看数字的个数
 *
 * 思路2：
 * 1. 顺序遍历，将每个数和它的计数放入一个map中
 * 2. 取map中计数最大的那个，判断它是否满足条件
 *
 * 思路3：
 * 1. 若一个数出现的次数超过数组长度的一半，则它出现的次数比其他所有数字出现的次数的总和还要多
 * 2. 遍历数组，若数组的元素与标记的数字相等，则计数加一，若不等，则减一，直到计数变为0，更改标记的数字
 * 3. 判断标记的数字是否为要找的数字
 */
package com.jony.nowcoder.offer.no28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-26 23:10
 **/
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        return method1(array);
    }

    private int method1(int[] array) {
        int mid = array.length / 2;
        Arrays.sort(array);
        int result = array[mid];
        int index = mid - 1;
        int count = 1;
        while (count <= mid && index >= 0) {
            if (array[index] == result) {
                count++;
                index--;
            } else {
                break;
            }
        }
        index = mid + 1;
        while (count <= mid && index < array.length) {
            if (array[index] == result) {
                count++;
                index++;
            } else {
                break;
            }
        }
        if (count <= mid) {
            result = 0;
        }
        return result;
    }

    private int method2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        Map.Entry<Integer, Integer> entry =
                map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();

        if (entry.getValue()>array.length/2){
            return entry.getKey();
        }
        return 0;
    }

    private int method3(int[] array) {
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (result == array[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                result = array[i];
                count = 1;
            }
        }
        int mid = array.length / 2;
        count = 0;
        int index = 0;
        while (count <= mid && index < array.length) {
            if (result == array[index]) {
                count++;
            }
            index++;
        }

        if (count <= mid) {
            result = 0;
        }
        return result;
    }
}
