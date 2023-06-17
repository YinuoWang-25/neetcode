package arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class L290_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        Map<Character, String> hash = new HashMap<>();
        Map<String, Character> reversedHash = new HashMap<>();

        if (strs.length != pattern.length())  {
            return false;
        }

        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            if (hash.containsKey(c) && !hash.get(c).equals(strs[i])) {
                return false;
            }

            if (reversedHash.containsKey(strs[i]) && !reversedHash.get(strs[i]).equals(c)) {
                return false;
            }

            hash.put(c, strs[i]);
            reversedHash.put(strs[i], c);

        }

        return true;
    }
}
