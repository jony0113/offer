/**
 * 题目：
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 思路1：
 * 二分查找，找到等于指定数字的那个索引，然后分别向前、向后遍历，直到不再相等
 * 思路2：
 * 二分查找，分别找到相等数字的第一个索引和最后一个索引
 * 思路3：
 * 二分查找k-0.5 和 k+0.5的插入位置
 */
package com.jony.nowcoder.offer.no37;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/5 22:56
 **/
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int index = -1;
        while (start <= end && end >= 0 && start <= array.length - 1) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                index = mid;
                break;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (index == -1) {
            return 0;
        } else {
            int count = 0;
            for (int i = index; i >= start; i--) {
                if (array[i] == k) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = index + 1; j <= end; j++) {
                if (array[j] == k) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
    }

    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                index = mid;
                break;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (index == -1) {
            return 0;
        } else {
            int l1 = start;
            int r1 = index;
            while (l1 < r1) {
                int mid = (l1 + r1) / 2;
                if (array[mid] < k) {
                    l1 = mid + 1;
                } else {
                    r1 = mid;
                }
            }
            int l2 = index;
            int r2 = end;
            while (l2 < r2) {
                // 注意这里需要为 (l2+r2+1) / 2 否则当只有两个的时候会死循环 想象index为0，1 ，mid = 0 ，走else逻辑 其实没有更新
                int mid = (l2 + r2 + 1) / 2;
                if (array[mid] > k) {
                    r2 = mid - 1;
                } else {
                    l2 = mid;
                }
            }
            return l2 - l1 + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetNumberOfK1(new int[] { 2, 2 }, 2));
    }
}
