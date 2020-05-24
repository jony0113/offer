/*
 * 题目：
 *
 * 思路：
 * 假定 List1长度: a+n  List2 长度:b+n, 且 a<b
 * 那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
 * 接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
 * 将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。
 * 或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
 *
 */
package com.jony.nowcoder.offer.no36;

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/5 22:26
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead1 : p1.next);
            p2 = (p2 == null ? pHead2 : p2.next);
        }
        return p1;
    }
}
