package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L39_combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), 0, candidates, target);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            cur.add(candidates[i]);
            dfs(res, cur, i, candidates, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
