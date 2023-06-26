package backtracking;

import java.util.Arrays;

public class L473_matchsticks_to_square {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int i: matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > sum / 4) {
            return false;
        }

        return dfs(matchsticks, matchsticks.length - 1, sum / 4, sum / 4, 0);
    }
    private boolean dfs(int[] matchsticks, int idx, int maxL, int space, int done) {
        if (done == 3) return true;

        for (int i = idx; i >= 0; i--) {
            int val = matchsticks[i];
            if (val > space) continue;
            matchsticks[i] = maxL + 1;
            if (val == space) {
                if (dfs(matchsticks, matchsticks.length - 2, maxL, maxL, done + 1))
                    return true;
            }
            else {
                if (dfs(matchsticks, i - 1, maxL, space - val, done)) return true;
            }

            matchsticks[i] = val;
            while (i > 0 && matchsticks[i - 1] == val) i--;
        }
        return false;
    }
}
