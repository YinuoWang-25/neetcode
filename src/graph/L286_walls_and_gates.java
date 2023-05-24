package graph;

import java.util.LinkedList;
import java.util.Queue;

public class L286_walls_and_gates {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dirs[k][0];
                int y = cur[1] + dirs[k][1];
                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
