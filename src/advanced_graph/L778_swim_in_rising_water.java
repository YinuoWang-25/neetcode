package advanced_graph;

import java.util.PriorityQueue;

public class L778_swim_in_rising_water {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], max = cur[2];
            for (int[] dir : dirs){
                int newI = dir[0] + i, newJ = dir[1] + j;
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= n)  continue;
                if (!visited[newI][newJ]){
                    visited[newI][newJ] = true;
                    int newMax = Math.max(max, grid[newI][newJ]);
                    if (newI == n - 1 && newJ == n - 1) {
                        return newMax;
                    }

                    pq.offer(new int[]{newI, newJ, newMax});
                }
            }
        }

        return 0;
    }
}
