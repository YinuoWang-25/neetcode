package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L652_find_duplicate_subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(res, new HashMap<>(), root);
        return res;
    }

    private String dfs(List<TreeNode> res, Map<String, Integer> counts, TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = dfs(res, counts, root.left);
        String right = dfs(res, counts, root.right);

        String cur = root.val + "," + left + "," + right;

        if (counts.containsKey(cur) && counts.get(cur) == 1) {
            res.add(root);
        }

        counts.put(cur, counts.getOrDefault(cur, 0) + 1);

        return cur;
    }
}
