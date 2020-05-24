/**
 * 题目：
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 思路：
 * 构建一个一样大小的数组保存当前位置是否已经进入过
 */
package com.jony.nowcoder.offer.no66;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/15 23:40
 **/
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] flag = new boolean[rows * cols];
        return count(threshold, rows, cols, flag, 0, 0);
    }

    private int count(int threshold, int rows, int cols, boolean[] flag, int i, int j) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[index] || getSum(i) + getSum(j) > threshold) {
            return 0;
        }
        flag[index] = true;
        return 1 + count(threshold, rows, cols, flag, i - 1, j)
                + count(threshold, rows, cols, flag, i + 1, j)
                + count(threshold, rows, cols, flag, i, j - 1)
                + count(threshold, rows, cols, flag, i, j + 1);
    }

    private int getSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(3, 4, 2));
    }
}
