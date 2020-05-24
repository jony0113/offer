/**
 * 题目：
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * <p>
 * 思路：
 * split，然后反序输出
 * 注意"    "这种情况
 */
package com.jony.nowcoder.offer.no44;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/8 19:36
 **/
public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
