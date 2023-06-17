package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L662_maximum_width {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    public int dfs(TreeNode root, int level, int index, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(index);
            end.add(index);
        } else {
            end.set(level, index);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * index, start, end);
        int right = dfs(root.right, level + 1, 2 * index + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
