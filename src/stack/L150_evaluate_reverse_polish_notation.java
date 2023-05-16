package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L150_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        String operators = "+-*/";

        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.offerFirst(Integer.valueOf(token));
                continue;
            }
            int a = stack.pollFirst();
            int b = stack.pollFirst();
            switch (token) {
                case "+":
                    stack.offerFirst(b + a);
                    break;
                case "-":
                    stack.offerFirst(b - a);
                    break;
                case "*":
                    stack.offerFirst(b * a);
                    break;
                default:
                    stack.offerFirst(b / a);
                    break;
            }
        }

        return stack.pollFirst();
    }
}
