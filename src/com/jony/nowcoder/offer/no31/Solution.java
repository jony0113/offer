/*
 * 题目：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 思路：以百位数字的个数举例来看
 * 1. 当百位数字是0时，例如11034，百位为1的数字个数可能为(100~199,1100~1199,2100~2199,...,10100~10199)，
 * 只受高位影响，总共有11*100个
 * 2. 当百位数字是1时，例如11134，百位数字仍然受高位影响，11*100；同时还受低位影响(11100~11134)，总共34+1个
 * 3. 当百位数字大于1时，例如11234，百位数字只受高位影响，为(11+1)*100（比为0时增加了11100~11199）
 */
package com.jony.nowcoder.offer.no31;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-31 00:43
 **/
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        while (n / i > 0) {
            int bigger = n / (i * 10);
            int current = (n / i) % 10;
            int lower = n % i;
            if (current == 0) {
                count += bigger * i;
            } else if (current == 1) {
                count += (bigger * i + lower + 1);
            } else {
                count += (bigger + 1) * i;
            }
            i *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1Between1AndN_Solution(100));
    }
}
