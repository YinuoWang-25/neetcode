package binary_search; /**
 * We use two pointers to mark two layers: parent and next. parent layer is set
 * up already, so we currently will take care of next layer
 * <p>
 * We have a pointer prev which is the prev pointer for current node
 */

import common.Node;

public class L116_populating_next_right_pointers {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node parent = root;
        Node next = parent.left;
        while (parent != null && next != null) {
            Node prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
        return root;
    }
}
