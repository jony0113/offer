/*
 * 题目：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * 思路1：
 * 1. 遍历str，使用LinkedHashMap保证插入顺序，value存放key出现的位置
 * 2. 遍历map，找到第一个位置只有一个的key，取value 中的第一个
 *
 * 思路2：
 * 1. 遍历str，以字符-65为下标，存储字符出现的次数
 * 2. 再次遍历str，如果当前字符存储的次数为1，返回index
 */

package com.jony.nowcoder.offer.no34;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/3 12:30
 **/
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (Objects.isNull(str) || str.length() < 1) {
            return -1;
        }
        int length = str.length();
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        int index = -1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 1) {
                index = list.get(0);
                break;
            }
        }
        return index;
    }

    public int FirstNotRepeatingChar1(String str) {
        if (Objects.isNull(str) || str.length() < 1) {
            return -1;
        }
        int length = str.length();
        // 字母的跨度范围最多有58
        int[] arr = new int[58];
        for (int i = 0; i < length; i++) {
            arr[str.charAt(i) - 'A'] += 1;
        }
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (arr[str.charAt(i) - 'A'] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

}
