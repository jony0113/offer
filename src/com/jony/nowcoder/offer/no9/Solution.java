/*
 * 题目：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：
 * 如果最后一次跳了1级，则有f(n-1)种
 * 如果最后一次跳了2级，则有f(n-2)种
 * ...
 * 所以f(n)=f(n-1)+f(n-2)+f(n-3)+...+f(1)+1
 */
package com.jony.nowcoder.offer.no9;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-06 00:33
 **/
public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] arr = new int[target + 1];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i <= target; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            arr[i] = sum;
        }
        return arr[target];
    }
}
