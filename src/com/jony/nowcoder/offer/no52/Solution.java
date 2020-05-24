/**
 * 题目：
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 思路：
 * 按照模式串的下一个字符来进行分类：
 * 1. 模式串下一个为*
 * 如果匹配串的当前字符和模式串当前字符不相同，则模式串往后移两位（*表示出现0次）
 * 如果匹配串的当前字符和模式串相同，则有以下三种：
 * 1.1 匹配串移动一位，模式串不动
 * 1.2 匹配串不动，模式串移动两位
 * 1.3 匹配传移动一位，模式串移动两位（可以由上面两种组合得到，可省略）
 * <p>
 * 2. 模式串下一个不为*，
 * 若匹配串当前字符和模式串相同，匹配串移动一位，模式串移动一位
 * 若匹配串当前字符和模式串不同，返回false
 */
package com.jony.nowcoder.offer.no52;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/10 23:23
 **/
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int p1, char[] pattern, int p2) {
        if (p2 == pattern.length) {
            return p1 == str.length;
        }
        if (p2 < pattern.length - 1 && pattern[p2 + 1] == '*') {
            if (p1 < str.length && (pattern[p2] == str[p1] || pattern[p2] == '.')) {
                return match(str, p1 + 1, pattern, p2) || match(str, p1, pattern, p2 + 2);
            } else {
                return match(str, p1, pattern, p2 + 2);
            }
        }
        if (p1 < str.length && (pattern[p2] == str[p1] || pattern[p2] == '.')) {
            return match(str, p1 + 1, pattern, p2 + 1);
        }
        return false;
    }
}
