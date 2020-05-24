/**
 * 题目：
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 思路：
 * 短路原理，如果n=1时，第一个表达式成立，直接返回，否则会走后面的递归
 */
package com.jony.nowcoder.offer.no47;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 23:13
 **/
public class Solution {
    public int Sum_Solution(int n) {
        int result = n;
        boolean a = result == 1 || (result = result + Sum_Solution(n - 1)) == 1;
        return result;
    }

}
