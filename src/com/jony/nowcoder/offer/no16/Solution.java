/*
 * 题目：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：
 * 首先找出较小的那个节点作为头节点head，然后让list1指向较小的那个链表，list2指向较大的那个链表
 * 然后让list1始终指向已排序的末端(头为head)
 *
 * 递归
 */
package com.jony.nowcoder.offer.no16;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-11 23:42
 **/
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        if (head == list2) {
            list2 = list1;
            list1 = head;
        }
        while (list1.next != null && list2.next != null) {
            if (list1.next.val <= list2.val) {
                list1 = list1.next;
            } else {
                ListNode temp = list2.next;
                list2.next = list1.next;
                list1.next = list2;
                list1 = list2.next;
                list2 = temp;
            }
        }
        if (list1.next == null) {
            list1.next = list2;
        } else {
            list2.next = list1;
        }
        return head;
    }

    public ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            head.next = merge2(list1.next, list2);
        } else {
            head = list2;
            head.next = merge2(list2.next, list1);
        }
        return head;
    }
}
