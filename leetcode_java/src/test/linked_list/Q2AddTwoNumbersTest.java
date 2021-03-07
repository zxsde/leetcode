
package test.linked_list;

import main.java.solutions.linked_list.Q2AddTwoNumbers2;
import org.junit.Test;

import main.java.common.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q2AddTwoNumbersTest {

    @Test
    public void addTwoNumbersTest() {
        // 链表 l1
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(4);
        l1_1.setNext(l1_2);
        l1_2.setNext(l1_3);

        // 链表 l2
        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(5);
        l2_1.setNext(l2_2);
        l2_2.setNext(l2_3);

        // 相加的结果
        ListNode res = new Q2AddTwoNumbers2().addTwoNumbers(l1_1, l2_1);

        // 期望的结果
        ListNode e_1 = new ListNode(7);
        ListNode e_2 = new ListNode(0);
        ListNode e_3 = new ListNode(0);
        ListNode e_4 = new ListNode(1);
        e_1.setNext(e_2);
        e_2.setNext(e_3);
        e_3.setNext(e_4);

        assertEquals(getval(e_1), getval(res));
    }

    // 把链表的 val 保存成列表，方便比较
    private List<Integer> getval(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.getVal());
            head = head.getNext();
        }
        return ans;
    }
}