package dynamic_programming;

import java.util.*;

public class L472_concatenated_words {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<String>(Arrays.asList(words));

        List<String> res = new ArrayList<String>();

        for (String word : words) {
            if (canConcatenate(word, dict)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean canConcatenate(String word, Set<String> dict) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];// store whether w.substr(0, i) can be formed by existing words
        Arrays.fill(dp, false);
        dp[0] = true;// empty string is always valid
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;// cannot start from here
            for (int j = i + 1; j <= n; j++) {// check whether w.substr(i, j - i) can be concatenated from i
                if (j - i < n && dict.contains(word.substring(i, j))) {// cannot be itself
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }
}
