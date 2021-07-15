
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
     * 把 ListNode 抽离成单独的模块，也是实际中常用的写法。
     * 所以边求和边尾插法构建链表即可，留意进位和遇到 null 的处理。
     * 时间复杂度：O(max(m, n))，m 和 n 分别为 l1 和 l2 的长度。
     * 空间复杂度：O(1)。
     *
     * @param l1 链表 l1
     * @param l2 链表 l2
     * @return ListNode，相加后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        // while时候就考虑是否有进位，循环结束就不需要再单独考虑是否有进位
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
