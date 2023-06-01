package linked_list;

import common.ListNode;

public class L92_reverse_linked_list_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode stub = dummy;

        int nodeNum = right - left + 1;

        while (left > 1) {
            stub = stub.next;
            left--;
        }

        ListNode originalFirst = stub.next;
        ListNode end = stub;
        ListNode tail = originalFirst;

        for (int i = 0; i < nodeNum; i++) {
            ListNode next = tail.next;
            tail.next = end;
            end = tail;
            tail = next;
        }

        stub.next = end;
        originalFirst.next = tail;

        return dummy.next;
    }
}
