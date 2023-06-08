package arrays_and_hashing;

public class L304_range_sum_query_2D_immutable {
    private int[][] sums;

    public L304_range_sum_query_2D_immutable(int[][] matrix) {
        if (matrix.length != 0) {
            sums = new int[matrix.length + 1][matrix[0].length + 1];
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sums[i + 1][j + 1] = sum + sums[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
