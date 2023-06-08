package tree;

import common.TreeNode;

public class L106_construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int position = findPosition(inorder, instart, inend, postorder[postend]);
        if (position == -1) {
            return null;
        }
        root.left = myBuildTree(inorder, instart, position - 1,
                postorder, poststart, poststart + position - instart - 1);
        root.right = myBuildTree(inorder, position + 1, inend,
                postorder, poststart + position - instart, postend - 1);

        return root;
    }

    private int findPosition(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
