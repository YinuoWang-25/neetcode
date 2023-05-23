package backtracking;

public class L79_word_search {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '#';
        boolean res = false;

        for (int k = 0; k < 4; k++) {
            res |= dfs(board, word, i + dirs[k][0], j + dirs[k][1], index + 1);
            if (res) {
                break;
            }
        }
        board[i][j] = c;
        return res;
    }
}
