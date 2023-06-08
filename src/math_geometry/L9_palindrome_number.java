package math_geometry;

public class L9_palindrome_number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return x == reverse(x);
    }

    private int reverse(int x) {
        int rst = 0;

        while (x > 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }

        return rst;
    }
}
