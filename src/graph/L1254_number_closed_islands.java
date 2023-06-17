package graph;

public class L1254_number_closed_islands {
    int[] directions = new int[]{0, 1, 0, -1, 0};

    public int closedIsland(int[][] g) {
        int n = g.length, m = g[0].length;

        for (int i = 0; i < n; i++) {
            fill(g, i, 0);
            fill(g, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            fill(g, 0, i);
            fill(g, n - 1, i);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == 0) {
                    res++;
                    fill(g, i, j);
                }
            }
        }

        return res;
    }

    private void fill(int[][] g, int x, int y) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == 1) {
            return;
        }

        g[x][y] = 1;

        for (int i = 0; i < directions.length - 1; i++) {
            fill(g, x + directions[i], y + directions[i + 1]);
        }
    }
}
