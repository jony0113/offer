/**
 * 题目：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 思路：
 * 遍历两次
 * 第一次：将有重复节点的值插入set
 * 第二次：从第二个节点开始，若节点的值在set中，则删除该节点
 * 最后 处理第一个节点，若第一个节点在set中，则删除
 */
package com.jony.nowcoder.offer.no56;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * Solution
 *
 * @author fangeng
 * @since 2020/3/12 21:45
 **/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Set<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                set.add(cur.val);
            }
            pre = pre.next;
            cur = cur.next;
        }
        pre = pHead;
        cur = pHead.next;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        if (set.contains(pHead.val)) {
            pHead = pHead.next;
        }
        return pHead;
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = pHead;
        ListNode pre = node;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }
}
