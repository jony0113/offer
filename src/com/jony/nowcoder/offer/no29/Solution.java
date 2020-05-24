/*
 * 题目：
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 *
 * 思路1：顺序遍历，如果发现比已有序列最大值小的则插入
 *
 * 思路2：利用最大堆，首先将前面k个数字排序成为最大堆，然后遍历剩下的元素，如果比堆顶元素小，
 * 则用新元素替换堆顶元素，然后重新调整，使堆仍然为一个最大堆
 *
 */
package com.jony.nowcoder.offer.no29;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-29 23:15
 **/
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k == 0 || k > input.length) {
            return result;
        }
        result = method1(input, k);
        return result;
    }

    private ArrayList<Integer> method1(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (result.size() < k || result.get(result.size() - 1) > input[i]) {
                int index = result.size();
                while (index > 0 && result.get(index - 1) > input[i]) {
                    index--;
                }
                result.add(index, input[i]);
            }
            if (result.size() > k) {
                result.remove(result.size() - 1);
            }
        }
        return result;
    }

    private ArrayList<Integer> method2(int[] input, int k) {
        int[] nums = Arrays.copyOf(input, k);
        for (int i = k / 2; i >= 0; i--) {
            adjustHeap(nums, i, k - 1);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < nums[0]) {
                nums[0] = input[i];
                adjustHeap(nums, 0, k - 1);
            }
        }
        for (int i = k - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    private void adjustHeap(int[] input, int index, int end) {
        int left = 2 * index + 1;
        while (left <= end) {
            if (input[index] < input[left]) {
                swap(input, index, left);
            }
            int right = left + 1;
            if (right <= end && input[index] < input[right]) {
                swap(input, index, left);
                index = right;
            } else {
                index = left;
            }
            left = 2 * index + 1;
        }
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().method2(new int[]{4,5,1,6,2,7,3,8},4));
    }
}
