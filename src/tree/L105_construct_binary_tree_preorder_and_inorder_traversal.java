package tree;

import common.TreeNode;

public class L105_construct_binary_tree_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        // 1. first element of preorder is root
        TreeNode root = new TreeNode(preorder[prestart]);

        // 2. find root's position in inorder array
        int position = findPosition(inorder, instart, inend, preorder[prestart]);
        if (position == -1) {
            return null;
        }

        root.left = buildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);

        root.right = buildTree(inorder, position + 1, inend,
                preorder, prestart + position - instart + 1, preend);
        return root;
    }

    private int findPosition(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
