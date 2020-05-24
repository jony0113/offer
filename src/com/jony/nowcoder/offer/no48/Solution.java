/**
 * 题目：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * <p>
 * 思路：
 * 考虑10进制下的情况，9+7，三步法：
 * 第一步：得到个位数相加的结果6，
 * 第二步：得到进位上的数为1，代表10
 * 第三部：循环第一步、第二步
 * <p>
 * 现在考虑二进制的情况9=1001 7=0111
 * 第一步：不考虑进位，相加等于1110=(1001^0111)
 * 第二步，9+7 实际进位情况为0010，可以看成是0001左移1位，即0010=(1001&0111)<<1
 * 第三步，循环第一步、第二步
 */
package com.jony.nowcoder.offer.no48;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 23:46
 **/
public class Solution {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num1 ^ num2;
            num2 = (temp & num2) << 1;
        }
        return num1;
    }
}
