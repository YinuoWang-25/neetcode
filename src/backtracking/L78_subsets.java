package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curList, int[] nums, int index) {
        res.add(new ArrayList<>(curList));

        for (int i = index; i < nums.length; i++) {
            curList.add(nums[i]);
            dfs(res, curList, nums, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
