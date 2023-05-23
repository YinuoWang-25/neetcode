package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            dfs(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
