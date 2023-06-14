package stack;

public class L1209_remove_adjacent_duplicates {
    public String removeDuplicates(String s, int k) {
        char[] chs = s.toCharArray();

        int[] count = new int[chs.length];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int last = sb.length() - 1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last - 1) ? count[last - 1] : 0);
            if (count[last] >= k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }

        return sb.toString();
    }
}
