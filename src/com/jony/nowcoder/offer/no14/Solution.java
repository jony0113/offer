/*
 * 题目：
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：
 * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。
 * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
 */
package com.jony.nowcoder.offer.no14;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-10 23:52
 **/
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        int count = 0;
        ListNode first = head, second = head;
        while (second.next != null) {
            count++;
            second = second.next;
            if (count >= k - 1) {
                first = first.next;
            }
        }
        if (count < k - 1) {
            return null;
        }
        return first;
    }

}
