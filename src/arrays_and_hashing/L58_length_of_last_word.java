package arrays_and_hashing;

public class L58_length_of_last_word {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chs = s.toCharArray();
        int last = chs.length - 1;

        while (last >= 0 && chs[last] == ' ') {
            last--;
        }

        int start = last;
        while (start >= 0 && chs[start] != ' ') {
            start--;
        }

        return last - start;
    }
}
