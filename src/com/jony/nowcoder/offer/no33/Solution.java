/*
 * 题目：
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 * 1. 丑数一定是其他的丑数*2，3，5后的值
 * 2. 分别找出每个数*2，3，5之后的值，把其中最小的放入
 */
package com.jony.nowcoder.offer.no33;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/2 22:52
 **/
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] items = new int[index];
        items[0] = 1;
        // 分别记录当前需要乘以2，3，5的数位于items数组的丑数的序号
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 0; i < index - 1; i++) {
            items[i + 1] = Math.min(items[i2] * 2, Math.min(items[i3] * 3, items[i5] * 5));
            // 如果当前序列里面的数放入了数组，则需要把序号加1
            if (items[i + 1] == items[i2] * 2) {
                i2++;
            }
            if (items[i + 1] == items[i3] * 3) {
                i3++;
            }
            if (items[i + 1] == items[i5] * 5) {
                i5++;
            }
        }
        return items[index - 1];
    }
}
