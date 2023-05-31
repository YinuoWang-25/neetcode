package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L71_simplify_path {
    public String simplifyPath(String path) {
        Deque<String> q = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (q.size() > 0) {
                    q.pollFirst();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                q.offerFirst(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append("/" + q.pollLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
