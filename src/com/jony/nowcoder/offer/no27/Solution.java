/*
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 思路：
 * 1. 先将字符串分割成字符数组，然后排序
 * 2. 然后顺序遍历，增加字符
 * 3. 注意如果有重复的字符，则在遍历时只需要在一个位置添加
 * 
 */
package com.jony.nowcoder.offer.no27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-24 00:18
 **/
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (list.isEmpty()) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(String.valueOf(chars[i]));
                list.add(temp);
            } else {
                ArrayList<ArrayList<String>> cur = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    ArrayList<String> last = list.get(j);
                    for (int k = 0; k <= last.size(); k++) {
                        if (k - 1 >= 0 && last.get(k - 1).equals(String.valueOf(chars[i]))) {
                            continue;
                        }
                        ArrayList<String> temp = new ArrayList<>(last);
                        temp.add(k, String.valueOf(chars[i]));
                        cur.add(temp);
                    }
                }
                list = cur;
            }
        }
        for (ArrayList<String> s : list) {
            result.add(String.join("", s));
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Permutation("ab"));
    }
}
