package tree;

import common.TreeNode;

import java.util.*;

public class L513_find_bottom_left_tree_value {
    public int findBottomLeftValue_bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (q.size() > 0) {
            int size = q.size();
            TreeNode cur = null;

            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if (cur == null) {
                    cur = tmp;
                }
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }


            if (q.size() == 0) {
                return cur.val;
            }
        }

        return -1;
    }

    int maxLayer = -1;
    TreeNode leftmost = null;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);

        return leftmost.val;
    }

    private void dfs(TreeNode root, int layer) {
        if (root == null) {
            return;
        }

        if (layer > maxLayer) {
            leftmost = root;
            maxLayer = layer;
        }

        dfs(root.left, layer + 1);
        dfs(root.right, layer + 1);
    }


}
