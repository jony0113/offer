/*
 * 题目：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：
 * 遍历，分为从左到右、从上到下、从右到左、从下到上循环，
 * 注意每一个边循环完后，不仅边界要变化，那一行/列对应的索引也要变化，否则会出现重复
 */
package com.jony.nowcoder.offer.no19;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-16 23:50
 **/
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null) {
            return arrayList;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int i = 0, j = 0;
        while (i >= top && i <= bottom && j >= left && j <= right) {
            while (i >= top && i <= bottom && j >= left && j <= right) {
                arrayList.add(matrix[i][j++]);
            }
            top++;
            j--;
            i++;
            while (i >= top && i <= bottom && j >= left && j <= right) {
                arrayList.add(matrix[i++][j]);
            }
            right--;
            i--;
            j--;
            while (i >= top && i <= bottom && j >= left && j <= right) {
                arrayList.add(matrix[i][j--]);
            }
            bottom--;
            j++;
            i--;
            while (i >= top && i <= bottom && j >= left && j <= right) {
                arrayList.add(matrix[i--][j]);
            }
            left++;
            i++;
            j++;
        }
        return arrayList;
    }
}
