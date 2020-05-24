/**
 * 题目：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * <p>
 * 思路：
 * 左移多少位即取前面多少位，分成两个子串，然后拼起来。
 * 注意n需要对字符串的长度取模
 */
package com.jony.nowcoder.offer.no43;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 19:29
 **/
public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        n = n % str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2 + s1;
    }
}
