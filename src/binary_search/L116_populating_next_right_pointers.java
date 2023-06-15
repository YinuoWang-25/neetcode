package binary_search;

import common.Node;
import java.util.*;

public class L116_populating_next_right_pointers {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (q.size() > 0 ) {
            int size = q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (prev == null) {
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return root;
    }
}
