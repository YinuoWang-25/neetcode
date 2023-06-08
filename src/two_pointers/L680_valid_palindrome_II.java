package two_pointers;/*
    two pointers going middle of string
    - > find the first different pair
    - > continue to check in two cases:
        1. delete left char
        2. delete right char
 */

public class L680_valid_palindrome_II {

    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            if (chs[left] == chs[right]) {
                left++;
                right--;
            } else {
                return isValid(chs, left + 1, right) || isValid(chs, left, right - 1);
            }
        }
        return true;
    }

    private boolean isValid(char[] chs, int left, int right) {
        while (left < right) {
            if (chs[left] == chs[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
