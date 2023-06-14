package linked_list;

import common.ListNode;

public class L1721_swapping_nodes_in_a_linked_list {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = findFirst(dummy, k);

        ListNode second = dummy;
        ListNode end = first;

        while (end != null) {
            second = second.next;
            end = end.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    private ListNode findFirst(ListNode pre, int k) {
        while(k > 0 && pre.next != null) {
            k--;
            pre = pre.next;
        }

        return pre;
    }
}
