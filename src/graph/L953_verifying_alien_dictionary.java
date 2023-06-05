package graph;

/*

Step 1: build the map mapping from char and its order

Step 2: iterate all pairs of words and compare them according to map:
    a. find first character on same position but diff in two words, return comparasion value
       based on map
    b. If not found, compare length of two words

*/

public class L953_verifying_alien_dictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (bigger(dict, words[i - 1], words[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean bigger(int[] dict, String s1, String s2) {
        int n = s1.length(), m = s2.length();

        for (int i = 0; i < n && i < m; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return dict[s1.charAt(i) - 'a'] > dict[s2.charAt(i) - 'a'];
            }
        }

        return n > m;
    }
}
