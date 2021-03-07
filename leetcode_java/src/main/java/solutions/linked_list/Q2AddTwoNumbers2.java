
package main.java.solutions.linked_list;

import main.java.common.ListNode;

/**
 * 5. Longest Palindromic Substring -- 两数相加
 * https://leetcode.com/problems/add-two-numbers
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q2AddTwoNumbers2 {
    /**
     * 把 ListNode 抽离成单独的模块，也是实际中常用的写法
     * 给定的链表和相加后的链表，都是头节点指向个位数，所以边加边尾插法构建结果就行
     *
     * @param l1 链表 l1
     * @param l2 链表 l2
     * @return ListNode，相加后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null ? l1.getVal() : 0);
            int y = (l2 != null ? l2.getVal() : 0);
            int sum = x + y + carry;
            carry = sum / 10;
            cur.setNext(new ListNode(sum % 10));
            cur = cur.getNext();
            l1 = (l1 != null ? l1.getNext() : null);
            l2 = (l2 != null ? l2.getNext() : null);
        }
        return head.getNext();
    }
}
