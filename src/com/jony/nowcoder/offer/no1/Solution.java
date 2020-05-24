/*
 * 题目：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 思路：
 * 从二维矩阵的左下角开始找，往上找变小，往右找变大
 */
package com.jony.nowcoder.offer.no1;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-01 23:34
 **/
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = array.length-1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
