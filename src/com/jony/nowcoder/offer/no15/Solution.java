/*
 * 题目
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 思路：
 * 用两个指针分别记录当前节点的前一个节点和后一个节点
 */
package com.jony.nowcoder.offer.no15;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-11 01:05
 **/
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = null, after = head.next;
        head.next = before;
        while (after != null) {
            before = head;
            head = after;
            after = head.next;
            head.next = before;
        }
        return head;
    }
}
