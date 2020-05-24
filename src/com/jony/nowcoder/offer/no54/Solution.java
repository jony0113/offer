/**
 * 题目：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 思路：
 * 使用set保存是否已经出现，使用list保存出现的顺序，如果已经出现过，从list中删除
 * 求第一个出现的时候，取list的第一个，否则返回#
 */
package com.jony.nowcoder.offer.no54;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/11 23:56
 **/
public class Solution {
    Set<Character> set = new HashSet<>();
    List<Character> list = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!set.contains(ch)) {
            set.add(ch);
            list.add(ch);
        } else {
            int index = list.indexOf(ch);
            if (index >= 0) {
                list.remove(list.indexOf(ch));
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (list.isEmpty()) {
            return '#';
        }
        return list.get(0);
    }
    
}
