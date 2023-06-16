package tree;

import common.TreeNode;

public class L538_convert_bst_to_greater_tree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode cur) {
        if (cur == null) {
            return;
        }

        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
