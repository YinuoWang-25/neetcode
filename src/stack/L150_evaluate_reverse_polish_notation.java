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
            int a = stack.pop();
            int b = stack.pop();
            switch (token) {
                case "+":
                    stack.push(b + a);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(b * a);
                    break;
                default:
                    stack.push(b / a);
                    break;
            }
        }

        return stack.pollFirst();
    }
}
