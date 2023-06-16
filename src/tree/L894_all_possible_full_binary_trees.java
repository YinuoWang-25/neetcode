package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L894_all_possible_full_binary_trees {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<TreeNode>> cache = new HashMap<>();
        cache.put(1, new ArrayList<>());
        cache.get(1).add(new TreeNode(0));

        for (int k = 2; k <= n; k++) {
            if (k % 2 == 0) continue;
            List<TreeNode> res = new ArrayList<>();
            for (int i = 1; i < k - 1; i++) {
                int j = k - i - 1;
                if (i % 2 == 0 || j % 2 == 0) continue;

                List<TreeNode> lefts = cache.get(i), rights = cache.get(j);

                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            cache.put(k, res);
        }

        return cache.get(n);
    }
}
