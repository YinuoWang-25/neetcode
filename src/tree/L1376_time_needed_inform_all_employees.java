package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1376_time_needed_inform_all_employees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            tree.putIfAbsent(manager[i], new ArrayList<>());
            tree.get(manager[i]).add(i);
        }

        return getMaxTime(tree, headID, informTime);
    }

    private int getMaxTime(Map<Integer, List<Integer>> graph, int start, int[] informTime) {
        if (!graph.containsKey(start)) return 0;

        int max = 0;
        for (int next : graph.get(start)) {
            int re = getMaxTime(graph, next, informTime);
            max = Math.max(max, re + informTime[start]);
        }

        return max;
    }
}
