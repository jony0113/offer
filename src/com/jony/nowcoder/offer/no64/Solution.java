/**
 * 题目：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 *
 * 思路：
 * 维护一个指针指向上一个滑动窗口里最大值的位置，
 * 若指针在本次的滑动窗口内，只需要比较窗口的最后一个值和指针指向的值的大小关系
 * 若指针不在本次的滑动窗口内，遍历滑动窗口内找到最大的
 */
package com.jony.nowcoder.offer.no64;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/15 00:12
 **/
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size < 1 || num.length < size) {
            return list;
        }
        int index = -1;
        for (int i = 0, j = size - 1; j < num.length; i++, j = i + size - 1) {
            if (index >= i && index <= j) {
                // 每次需要和新增加的一位比较
                if (num[j] > num[index]) {
                    index = j;
                }
                list.add(num[index]);
                continue;
            }
            int temp = num[i];
            int k = i + 1;
            while (k <= j) {
                if (temp < num[k]) {
                    temp = num[k];
                    index = k;
                }
                k++;
            }
            list.add(temp);
        }
        return list;
    }
}
