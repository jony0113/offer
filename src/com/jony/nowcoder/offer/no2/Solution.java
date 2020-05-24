/*
 * 题目：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：
 * 原地替换的方法，先顺序扫一遍，记录空格的个数，申请对应大小的空间，然后从后往前遍历并替换
 */
package com.jony.nowcoder.offer.no2;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-01 23:54
 **/
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str==null||str.length()==0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = str.length();
        for (int i=0;i<n;i++){
            char c = str.charAt(i);
            if (c==' '){
                stringBuilder.append("%20");
            }else {
               stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
