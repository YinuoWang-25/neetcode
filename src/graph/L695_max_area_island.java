package graph;

public class L695_max_area_island {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;

        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);

        return area;

    }
}
