/*
 * 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路：
 * 1. 首先判断是否旋转了，如果没旋转，那么最小值为第一个元素；
 * 2. 如果旋转了，那么可以使用二分查找，查找范围的左边界、中间、右边界分别为start、index、end
 *      a. 如果start的值比index的值大，说明index位于后半部分升序序列，最小值应该位于前半部分，这时让end指向index
 *      b. 否则最小值位于后半部分，这时让start指向index
 *      c. 按照上述规则start一直指向前半部分、end一直指向后半部分，当start=end-1时，end指向的就是最小值
 *
 */
package com.jony.nowcoder.offer.no6;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-04 23:53
 **/
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;

        // 未旋转
        if (array[start] < array[end]) {
            return array[0];
        }
        while (end - start > 1) {
            int index = (start + end) / 2;
            if (array[start] > array[index]) {
                end = index;
            } else {
                start = index;
            }
        }
        return array[end];
    }
}
