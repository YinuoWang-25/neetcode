package advanced_graph;

import java.util.*;

public class L743_network_delay_time {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Set<Integer> set = new HashSet<>();

        q.add(new int[]{k, 0});
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (!set.add(cur[0])) continue;

            List<int[]> nexts = graph.get(cur[0]);
            res = Math.max(res, cur[1]);
            for (int[] next : nexts) {
                q.offer(new int[]{next[0], cur[1] + next[1]});
            }
        }
        return set.size() == n ? res : -1;
    }
}
