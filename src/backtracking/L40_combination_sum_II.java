package backtracking;// 40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L40_combination_sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
        if (remain < 0) return;

        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i - 1]) continue;
            tempList.add(cand[i]);
            backtrack(list, tempList, cand, remain - cand[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
