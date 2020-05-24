/**
 * 题目：
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 思路：
 * 可以得出f(n)=max( f(i) * f(n-i) )
 * 动态规划
 */
package com.jony.nowcoder.offer.no67;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/16 00:35
 **/
public class Solution {
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        return cutRopeCore(target);
    }

    /**
     * 计算最大长度，包括只剪一段的情况
     *
     * @param target
     *
     * @return
     */
    private int cutRopeCore(int target) {
        if (target <= 4) {
            return target;
        }
        int max = 0;
        for (int i = 1; i <= target / 2; i++) {
            max = Math.max(max, cutRopeCore(i) * cutRopeCore(target - i));
        }
        return max;
    }

    public int cutRope1(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] temp = new int[target + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 3;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                temp[i] = Math.max(temp[i], temp[j] * temp[i - j]);
            }
        }
        return temp[target];
    }
}
