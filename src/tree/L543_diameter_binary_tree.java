package tree;

import common.TreeNode;

public class L543_diameter_binary_tree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);


        res = Math.max(res, l + r + 1);

        return Math.max(l, r) + 1;
    }
}
