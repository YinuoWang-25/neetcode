package graph;

import java.util.*;

public class L1129_shortest_path_with_alternating_colors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }

        for (int[] redEdge : redEdges) {
            graph[0][redEdge[0]].add(redEdge[1]);
        }

        for (int[] blueEdge : blueEdges) {
            graph[1][blueEdge[0]].add(blueEdge[1]);
        }

        int[][] res = new int[2][n];

        for (int i = 1; i < n; i++) {
            res[0][i] = 2 * n;
            res[1][i] = 2 * n;
        }
        // Q entries are vert with a color (up to that point)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0}); // either with red or with blue
        q.offer(new int[] {0, 1}); 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int vert = cur[0];
            int color = cur[1];
            // No need to keep track of level up to now
            // only need to keep what color - and the length
            // is automatically derived from previous node
            for (int nxt : graph[1 - color][vert]) {
                if (res[1 - color][nxt] == 2 * n) {
                    res[1 - color][nxt] = 1 + res[color][vert];
                    q.offer(new int[] {nxt, 1 - color});
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Math.min(res[0][i], res[1][i]);
            ans[i] = (t == 2 * n) ? -1 : t;
        }
        
        return ans;
    }
}
