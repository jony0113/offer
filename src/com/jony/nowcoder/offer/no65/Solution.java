/**
 * 题目：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * <p>
 * <p>
 * 思路：
 * 1. 构建一个跟矩阵同样的数组，用来标识该位置是否已经进入过；
 */
package com.jony.nowcoder.offer.no65;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/15 22:11
 **/
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || matrix.length < str.length) {
            return false;
        }
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, str, i, j, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param matrix 矩阵
     * @param rows   矩阵的行数
     * @param cols   矩阵的列数
     * @param str    要找的字符串
     * @param i      开始查找的元素位于矩阵的哪一行
     * @param j      开始查找的元素位于矩阵的哪一列
     * @param flag   标识矩阵对应位置是否已经进入过
     * @param k      标识当前要找的第一个字符位于字符串中的位置
     *
     * @return
     */
    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] flag, int k) {
        int index = i * cols + j;

        // 校验当前字符是否符合
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }

        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;

        if (hasPath(matrix, rows, cols, str, i - 1, j, flag, k + 1)
                || hasPath(matrix, rows, cols, str, i + 1, j, flag, k + 1)
                || hasPath(matrix, rows, cols, str, i, j - 1, flag, k + 1)
                || hasPath(matrix, rows, cols, str, i, j + 1, flag, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
