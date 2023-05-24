package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90_subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);

        dfs(nums, new ArrayList<>(), 0, ans);

        return ans;
    }

    private void dfs(int[] nums, List<Integer> cur, int index, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            dfs(nums, cur, i + 1, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
