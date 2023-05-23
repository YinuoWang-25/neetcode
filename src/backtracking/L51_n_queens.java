package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L51_n_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), n);

        return res;
    }

    private void dfs(List<List<String>> res, List<Integer> cols, int n) {
        if (cols.size() == n) {
            res.add(encode(cols, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                dfs(res, cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int r = 0; r < cols.size(); r++) {
            if (cols.get(r) == col) return false;
            if (cols.get(r) + r == row + col) return false;
            if (r - cols.get(r) == row - col) return false;
        }
        return true;
    }

    private List<String> encode(List<Integer> cols, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == cols.get(i) ? "Q" : ".");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
