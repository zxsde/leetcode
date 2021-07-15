
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
 * 题目： https://leetcode.com/problems/add-two-numbers
 * 参考： https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q2AddTwoNumbers {

    /**
     * 注意 l1 和 l2 的头节点指向个位数，返回的结果，头节点也是指向个位数。
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
        while (l1 != null || l2 != null){
            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        // 处理进位
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

}
