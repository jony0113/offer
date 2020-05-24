/**
 * 题目：
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,
 * 今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,
 * 让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 * <p>
 * 思路：
 * 利用数组存储某位小朋友是否出局
 */
package com.jony.nowcoder.offer.no46;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 21:58
 **/
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m <= 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int[] arr = new int[n];
        int count = 0;
        int p = 0;
        while (count < n - 1) {
            for (int i = 0; i < m; i++) {
                // 跳过已经出局的编号
                while (arr[(p + i) % n] == 1) {
                    p = (p + 1) % n;
                }
            }
            // 出局的编号的数组值变为1，并且将下次的起始编号设置为下一个
            p = (p + m - 1) % n;
            arr[p++] = 1;
            count++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                res = i;
            }
        }
        return res;
    }

}
