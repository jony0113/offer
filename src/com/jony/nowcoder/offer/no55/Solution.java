/**
 * 题目：
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * <p>
 * 思路：
 * 遍历链表，用一个set保存已经遍历过的节点，当遇到set中已经存在的节点时，说明遇到了环的入口
 */
package com.jony.nowcoder.offer.no55;

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
 * @since 2020/3/12 21:27
 **/
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode node = pHead;
        Set<ListNode> set = new HashSet<>();
        while (node.next != null) {
            if (set.contains(node.next)) {
                return node.next;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
