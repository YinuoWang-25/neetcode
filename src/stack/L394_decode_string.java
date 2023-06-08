package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L394_decode_string {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        String res = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.offerFirst(res);
                nums.offerFirst(num);
                res = "";
                num = 0;
            } else if (c == ']') {
                String p = stack.pollFirst();
                int k = nums.pollFirst();
                for (int j = 0; j < k; j++) {
                    p = p + res;
                }
                res = p;
            } else if (Character.isLetter(c)) {
                res += c;
            } else {
                num = num * 10 + (c - '0');
            }
        }

        return res;
    }
}
