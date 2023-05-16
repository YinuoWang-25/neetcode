package sliding_window;

public class L567_Permutation_In_String {
    public boolean checkInclusionII(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] hash = new char[26];
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }

        int left = 0, right = 0, count = s1.length();

        while (right < s1.length() - 1) {
            if (hash[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            hash[s2.charAt(right) - 'a']--;
            right++;
        }

        while (right < s2.length()) {
            if (hash[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            if (count == 0) return true;
            hash[s2.charAt(right) - 'a']--;


            hash[s2.charAt(left) - 'a']++;
            if (hash[s2.charAt(left) - 'a'] > 0) {
                count++;
            }

            left++;
            right++;
        }

        return false;
    }
}
