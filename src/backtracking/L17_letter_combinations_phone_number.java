package backtracking;

import java.util.LinkedList;
import java.util.List;

public class L17_letter_combinations_phone_number {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combination(digits.toCharArray(), numToChar, 0, new StringBuilder(), res);

        return res;
    }

    private void combination(char[] number, String[] numToChar, int level, StringBuilder sb, List<String> ans) {

        if (level == number.length) {
            ans.add(sb.toString());
            return;
        }

        char[] chs = numToChar[number[level] - '0'].toCharArray();

        if (chs.length == 0) {
            combination(number, numToChar, level + 1, sb, ans);
        } else {
            for (char ch : chs) {
                combination(number, numToChar, level + 1, sb.append(ch), ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
