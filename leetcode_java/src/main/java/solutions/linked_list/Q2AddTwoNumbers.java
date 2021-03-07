
package main.java.solutions.linked_list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 5. Longest Palindromic Substring -- 两数相加
 * https://leetcode.com/problems/add-two-numbers
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q2AddTwoNumbers {

    /**
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
            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        return head.next;
    }

    @Test
    public void addTwoNumbersTest() {
        // 链表 l1
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        // 链表 l2
        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(5);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        // 相加的结果
        ListNode res = addTwoNumbers(l1_1, l2_1);

        // 期望的结果
        ListNode e_1 = new ListNode(7);
        ListNode e_2 = new ListNode(0);
        ListNode e_3 = new ListNode(0);
        ListNode e_4 = new ListNode(1);
        e_1.next = e_2;
        e_2.next = e_3;
        e_3.next = e_4;

        assertEquals(getval(e_1), getval(res));
    }

    // 把链表的 val 保存成列表，方便比较
    private List<Integer> getval(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }
}
