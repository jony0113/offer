/*
 * 题目：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 例如
 * 输入 1,2,3,4,5,6,7,0
 * 输出 7
 *
 * 思路1：
 * 会导致超时
 *
 * 思路2：归并法
 * 在归并的时候，数组A、B合并之后的总的逆序对个数是A中逆序对+B中逆序对+逆序对两个数分别在A、B中的
 * 在计算的过程中需要带上%1000000007 否则会出错
 *
 */
package com.jony.nowcoder.offer.no35;

import java.util.Objects;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/3 23:00
 **/
public class Solution {
    public int InversePairs(int[] array) {
        if (Objects.isNull(array) || array.length < 2) {
            return 0;
        }
        return countPairs(array, 0, array.length - 1) % 1000000007;

    }

    private int countPairs(int[] arr, int start, int end) {
        if (end <= start) {
            return 0;
        }
        // 如果两组数组分为[start,mid-1] [mid,end] 要注意这里需要+1 否则当只有两个数的时候，会一直没办法将两个数分开
        // int mid = (start + end +1) /2
        int mid = (start + end) / 2;
        int left = countPairs(arr, start, mid) % 1000000007;
        int right = countPairs(arr, mid + 1, end) % 1000000007;
        int two = twoArr(arr, start, mid, end) % 1000000007;
        return (left + right + two) % 1000000007;
    }

    private int twoArr(int[] arr, int start, int mid, int end) {
        int count = 0;
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int p = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[j++];
                count = (count + (mid - i + 1)) % 1000000007;
            }
        }
        while (i <= mid) {
            temp[p++] = arr[i++];
        }
        while (j <= end) {
            temp[p++] = arr[j++];
        }
        for (int k = 0; k < end - start + 1; k++) {
            arr[start + k] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().InversePairs(new int[] { 1, 2, 3, 4, 5, 6, 7, 0 }));
    }
}
