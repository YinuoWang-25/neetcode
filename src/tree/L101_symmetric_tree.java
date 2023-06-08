package tree;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);

    }
}
