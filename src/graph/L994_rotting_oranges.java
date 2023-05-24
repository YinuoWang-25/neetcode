package graph;

import java.util.LinkedList;
import java.util.Queue;

public class L994_rotting_oranges {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int count = 0, step = 1, res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                else if (grid[i][j] == 1) count++;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dirs[k][0], y = cur[1] + dirs[k][1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    count--;
                    res = step;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }

        return count == 0 ? res : -1;
    }
}
