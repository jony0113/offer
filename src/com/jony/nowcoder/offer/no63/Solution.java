/**
 * 思路：
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
package com.jony.nowcoder.offer.no63;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/14 23:55
 **/
public class Solution {
    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int length = list.size();
            int i = length - 1;
            boolean flag = false;
            while (i >= 0) {
                if (num > list.get(i)) {
                    flag = true;
                    list.add(i + 1, num);
                    break;
                }
                i--;
            }
            if (!flag) {
                list.add(0, num);
            }
        }
    }

    public Double GetMedian() {
        int length = list.size();
        if (length < 1) {
            return 0D;
        }
        if (length % 2 == 0) {
            double num1 = list.get(length / 2 - 1);
            double num2 = list.get(length / 2);
            return (num1 + num2) / 2;
        } else {
            return Double.valueOf(list.get(length / 2));
        }
    }
}
