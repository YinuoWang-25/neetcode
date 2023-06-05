package graph;

public class L1905_count_sub_islands {
    int[][] delta = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i , j)) {
                    res++;
                }
            }
        }


        return res;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }

        grid1[i][j] = 0;
        grid2[i][j] = 0;

        boolean res = true;
        for (int d = 0; d < 4; d++) {
            res &= isSubIsland(grid1, grid2, i + delta[d][0], j + delta[d][1]);
        }

        return res;
    }
}
