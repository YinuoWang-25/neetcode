package linked_list;

import common.ListNode;

public class L160_intersection_two_linkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = getLen(headA);
        int sizeB = getLen(headB);
        while (sizeA > sizeB) {
            headA = headA.next;
            sizeA--;
        }
        while (sizeA < sizeB) {
            headB = headB.next;
            sizeB--;
        }
        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
