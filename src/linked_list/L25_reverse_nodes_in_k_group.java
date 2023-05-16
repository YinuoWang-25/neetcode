package L25_reverse_nodes_in_K_group;

import common.ListNode;

public class L25_ReverseNodesInKGroup {
    /**
     * recursive
     */
    public ListNode reverseKGroupI(ListNode head, int k) {
        if (head == null) return null;
        ListNode h = head, p = head;
        int count = 1;
        while (h.next != null && count < k) {
            h = h.next;
            count++;
        }
        if (count == k) {
            ListNode post = reverseKGroupI(h.next, k);
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

    /**
     * iterative
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode first = prev.next;
            ListNode last = first;
            for (int i = 0; i < k - 1; i++) {
                if (last == null) return dummy.next;
                last = last.next;
            }
            if (last == null) return dummy.next;
            ListNode tail = last.next;
            ListNode cur = first;
            while (cur != tail) {
                ListNode next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = next;
            }
            first.next = tail;
            prev = first;
            head = prev.next;
        }
        return dummy.next;
    }
}
