/*
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：
 * 遍历链表，将新链表的next设置正确，同时用一个map存原链表和新链表节点的对应关系
 * 再次遍历链表，设置新链表的random
 * 多耗用了两倍的存储
 *
 * 另一种思路：将新创建的链表的每个节点放在原链表的后面，然后设置完random后，再拆开
 *
 */
package com.jony.nowcoder.offer.no25;

import java.util.HashMap;
import java.util.Map;
/**
 * Solution
 *
 * @author fangeng
 * @since 2019-07-22 23:32
 **/
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode randomListNode = new RandomListNode(pHead.label);
        map.put(pHead, randomListNode);
        RandomListNode origin = pHead;
        RandomListNode now = randomListNode;
        while (origin.next != null) {
            RandomListNode temp = new RandomListNode(origin.next.label);
            now.next = temp;
            origin = origin.next;
            now = temp;
            map.put(origin, now);
        }
        origin = pHead;
        now = randomListNode;
        while (origin != null) {
            now.random = map.get(origin.random);
            origin = origin.next;
            now = now.next;
        }
        return randomListNode;
    }
}
