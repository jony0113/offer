/**
 * 题目：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 思路：
 * 整数：
 * 第一位可以为+、-、[0~9]，其他必须为[0~9]
 * 小数(包括科学记数法)：
 * 第一位可以为+、-、.、[0~9]
 * 其他位在遇到e、E之前，若第一位为.，则只能为[0~9]，否则可以为.、[0~9]
 * 在e、E之后，若没有了，则不是数值，否则，后续只能为整数
 */
package com.jony.nowcoder.offer.no53;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/11 23:10
 **/
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return isInteger(str, 0) || isDouble(str);
    }

    private boolean isInteger(char[] str, int index) {
        char c = str[index];
        if (c == '+' || c == '-' || c >= '0' && c <= '9') {
            for (int i = index + 1; i < str.length; i++) {
                if (str[i] < '0' || str[i] > '9') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isDouble(char[] str) {
        char c = str[0];
        if (c == '+' || c == '-' || c == '.' || c >= '0' && c <= '9') {
            // 判断是否能够为.
            boolean canBeDot = str[0] != '.';
            for (int i = 1; i < str.length; i++) {
                if (str[i] == '.') {
                    if (canBeDot) {
                        canBeDot = false;
                    } else {
                        return false;
                    }
                } else if (str[i] == 'e' || str[i] == 'E') {
                    if (i == str.length - 1) {
                        return false;
                    }
                    return isInteger(str, i + 1);
                } else if (str[i] < '0' || str[i] > '9') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
