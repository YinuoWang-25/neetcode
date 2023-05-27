package linked_list;

import common.ListNode;

public class L148_sort_list {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preMiddle = findMiddle(head);
        ListNode right = preMiddle.next;
        preMiddle.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(right);
        return merge(first, second);

    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (left != null || right != null) {
            int num1 = left == null ? Integer.MAX_VALUE : left.val;
            int num2 = right == null ? Integer.MAX_VALUE : right.val;
            if (num1 <= num2) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
