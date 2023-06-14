package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L402_remove_k_digits {
    public String removeKdigits(String num, int k) {
        int len = num.length();

        //corner case
        if (k == len) {
            return "0";
        }

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(num.charAt(i));
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}
