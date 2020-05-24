/*
 * 题目：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路：
 * 当n<=0，有0种
 * 当n=1时，有1种
 * 当n=2时，有两种
 * 当n>=3时，
 *      若第一个竖着放，则有f(n-1)种
 *      若第一个横着放，则有f(n-2)种
 */
package com.jony.nowcoder.offer.no10;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-06 17:44
 **/
public class Solution {
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= target; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
