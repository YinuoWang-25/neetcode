package linked_list;

import common.ListNode;

public class L25_reverse_nodes_in_k_group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode h = head, p = head;
        int count = 1;
        while (h.next != null && count < k) {
            h = h.next;
            count++;
        }
        if (count == k) {
            ListNode post = reverseKGroup(h.next, k);
            h.next = null;
            ListNode[] result = reverse(p);
            result[0].next = post;
            head = result[1];
        }
        return head;
    }

    private ListNode[] reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return new ListNode[]{head, pre};
    }
}
