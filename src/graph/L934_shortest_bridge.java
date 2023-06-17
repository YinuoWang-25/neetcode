package graph;
/**
 * 1. DFS find one island and add all point to a queue
 * 2. BFS to find the min steps which is the shortest bridge
 */

import java.util.LinkedList;
import java.util.Queue;

public class L934_shortest_bridge {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length, step = 0;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        boolean foundIsland = false;
        for (int i = 0; i < m; i++) {
            if (foundIsland) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, dirs, i, j);
                    foundIsland = true;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0], y = cell[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;

                    if (grid[x][y] == 1) {
                        return step;
                    } else {
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }

            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int[][] dirs, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        q.offer(new int[]{i, j});

        for (int[] dir : dirs) {
            dfs(A, visited, q, dirs, i + dir[0], j + dir[1]);
        }
    }
}
