package dynamic_programming;

public class L329_longest_increasing_path_matrix {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] mem = new int[m][n];
        int res = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, mem));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] != 0) {
            return mem[i][j];
        }

        mem[i][j] = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            mem[i][j] = Math.max(mem[i][j], 1 + dfs(matrix, x, y, mem));
        }

        return mem[i][j];
    }
}
