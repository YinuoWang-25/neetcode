package dynamic_programming;

public class L97_interleaving_string {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        boolean[][] dp = new boolean[chs1.length + 1][chs2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= chs1.length; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= chs2.length; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                dp[i][j] = dp[i - 1][j] && chs1[i - 1] == chs3[i + j - 1];
                dp[i][j] = dp[i][j] || (dp[i][j - 1] && chs2[j - 1] == chs3[i + j - 1]);
            }
        }

        return dp[chs1.length][chs2.length];
    }
}
