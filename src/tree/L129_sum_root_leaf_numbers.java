package tree;

import common.TreeNode;

public class L129_sum_root_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];

        dfs(root, 0, res);

        return res[0];
    }

    private void dfs(TreeNode root, int cur, int[] res) {
        if (root == null) {
            return;
        }

        cur = cur * 10 + root.val;

        if (root.left == null && root.right == null) {
            res[0] += cur;
            return;
        }

        dfs(root.left, cur, res);
        dfs(root.right, cur, res);
    }
}
