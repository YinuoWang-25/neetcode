package linked_list;

import common.ListNode;

public class L83_remove_duplicates_from_sorted_list {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }

            prev.next = head;
            prev = head;
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = cur;

            }
            cur = cur.next;
        }

        prev.next = null;

        return head;
    }
}
