package greedy;

public class L678_valid_parenthesis_string {
    public boolean checkValidString(String s) {
        return backtracking(s, 0, 0, 0);
    }

    private boolean backtracking(String s, int left, int right, int index) {
        if (index == s.length()) {
            return left == right;
        }

        if (left < right) {
            return false;
        }

        if (s.charAt(index) == '(') {
            return backtracking(s, left + 1, right, index + 1);
        } else if (s.charAt(index) == ')') {
            return backtracking(s, left, right + 1, index + 1);
        } else {
            if (left == right) {
                return backtracking(s, left + 1, right, index + 1) || backtracking(s, left, right, index + 1);
            } else {
                return backtracking(s, left + 1, right, index + 1) || backtracking(s, left, right, index + 1)
                        || backtracking(s, left, right + 1, index + 1);
            }
        }
    }
}
