/**
 * 题目：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 思路：
 * 1. 先trim，如果有符号位，记录符号
 * 2. 从后往前遍历，计算，注意需要使用long存储，否则可能存在超过int能表达的最大值
 * 3. 最后需要跟int的边界比较
 */
package com.jony.nowcoder.offer.no49;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/9 23:47
 **/
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int factor = 1;
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            factor = -1;
            str = str.substring(1);
        }
        long result = 0;
        int last = str.length() - 1;
        for (int i = last; i >= 0; i--) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result += (c - '0') * (long) (Math.pow(10, last - i));
            } else {
                result = 0;
                break;
            }
        }
        result = factor * result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("-2147483649"));
    }
}
