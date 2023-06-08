package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L103_binary_tree_zigzag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode cur = deque.pollLast();
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    curList.add(cur.val);
                } else {
                    TreeNode cur = deque.pollFirst();
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    curList.add(cur.val);
                }

            }

            leftToRight = !leftToRight;

            res.add(curList);
        }

        return res;
    }
}
