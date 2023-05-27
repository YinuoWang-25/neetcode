package arrays_and_hashing;

/*
    Sliding window
        expand: put one more character in the sliding window
        get result: count == 0
        shrink: remove on character from left when length is enough
 */

import java.util.ArrayList;
import java.util.List;

public class L438_find_all_anagrams_string {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        int count = 0;
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
            if (hash[c - 'a'] == 1) {
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            hash[s.charAt(right) - 'a']--;
            if (hash[s.charAt(right) - 'a'] == 0) count--;
            right++;
            if (count == 0) {
                ans.add(left);
            }
            if (right - left == p.length()) {
                hash[s.charAt(left) - 'a']++;
                if (hash[s.charAt(left) - 'a'] == 1) count++;
                left++;
            }
        }
        return ans;

    }
}
