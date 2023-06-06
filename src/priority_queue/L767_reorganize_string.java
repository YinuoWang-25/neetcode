package priority_queue;

/*
1. Find the letter with max frequency

2. Check whether we could put this letter one after two each other
    max > (S.length() + 1) / 2

3. put this letter in positions 0, 2, 4...

4. put other letters
 */

public class L767_reorganize_string {
    public String reorganizeString(String s) {
        // find the character with max frequency
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        // check whether we could make it valid
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        // put this letter in positions 0, 2, 4...
        char[] res = new char[s.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }
}
