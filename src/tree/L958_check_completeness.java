package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L958_check_completeness {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur != null) {
                if (end) {
                    return false;
                }
                q.offer(cur.left);
                q.offer(cur.right);
            } else {
                end = true;
            }
        }

        return true;
    }
}
