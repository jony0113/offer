/*
 * 题目：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 思路：
 * 顺序遍历链表，并将每个元素放入栈，然后将栈中的元素一个个推出
 */
package com.jony.nowcoder.offer.no3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-02 00:11
 **/
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
