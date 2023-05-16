package linked_list;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class L138_copy_list_random_pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node first = head;

        while (head != null) {
            map.putIfAbsent(head, new Node(head.val));

            if (head.next != null) {
                map.putIfAbsent(head.next, new Node(head.next.val));
                map.get(head).next = map.get(head.next);
            }

            if (head.random != null) {
                map.putIfAbsent(head.random, new Node(head.random.val));
                map.get(head).random = map.get(head.random);
            }

            head = head.next;
        }
        
        return map.get(first);
    }
}
