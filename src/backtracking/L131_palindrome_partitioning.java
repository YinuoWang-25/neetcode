package backtracking;

import java.util.ArrayList;
import java.util.List;

public class L131_palindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> cur, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int end = index; end < s.length(); end++) {
            String sub = s.substring(index, end + 1);
            if (isPalindrome(sub)) {
                cur.add(sub);
                dfs(res, cur, s, end + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
