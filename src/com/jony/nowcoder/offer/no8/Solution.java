/*
 * 题目：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路：
 * 如果最后一步跨1级台阶，则有f(n-1)种走法
 * 如果最后一步跨2级台阶，则有f(n-2)种走法
 * 所以实质上还是斐波那契数列，只不过在n=2时，值为2
 */
package com.jony.nowcoder.offer.no8;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-06 00:19
 **/
public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target==2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= target; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
