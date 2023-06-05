package graph;

import java.util.*;

public class L1091_shortest_path_binary_matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // (0, 0) -> "0 + 0"
        Map<String, String> parents = new HashMap<>();
        Deque<int[]> q = new LinkedList<>();
        q.offerLast(new int[]{0, 0});
        grid[0][0] = 1;
        parents.put("0 + 0", "0 + 0");

        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.pollFirst();

                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1)  {
                    printPath(parents, cur[0], cur[1]);
                    return res;
                }

                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == 1) continue;

                    q.offerLast(new int[]{nx, ny});
                    parents.put(nx + " + " + ny, cur[0] + " + " + cur[1]);
                    grid[nx][ny] = 1;
                }

            }
            res++;
        }

        return -1;
    }

    private void printPath( Map<String, String> parents, int i, int j) {
        String cur = i + " + " + j;
        while (true) {
            System.out.println(cur);
            if (parents.get(cur).equals(cur)) {
                return;
            } else {
                cur = parents.get(cur);
            }
        }
    }
}