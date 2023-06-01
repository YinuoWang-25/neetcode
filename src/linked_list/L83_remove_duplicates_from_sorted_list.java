package linked_list;

import common.ListNode;

public class L83_remove_duplicates_from_sorted_list {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }

            prev.next = head;
            prev = prev.next;
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode prev = dummy;

        while (head != null) {
            if (head.val != prev.val) {
                prev.next = head;
                prev = prev.next;
            }

            head = head.next;
        }

        prev.next = null;

        return dummy.next;
    }
}
