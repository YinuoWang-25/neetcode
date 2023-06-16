package tree;
import common.TreeNode;

public class L450_delete_node_in_bst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // find the min node at right child
                // replace the number of root node
                root.val = findMin(root.right);
                // delete min node
                root.right = deleteNode(root.right, root.val);
                return root;
            }
        }
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
