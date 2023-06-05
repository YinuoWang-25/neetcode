package graph;

import java.util.*;

public class L752_open_the_lock {
    public int openLock(String[] deadends, String target) {
        Set<String> invalid = new HashSet<>();
        for (String d : deadends) {
            if (d.equals(target) || d.equals("0000")) return -1;
            invalid.add(d);
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        invalid.add("0000");

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }

                List<String> nexts = getNexts(cur);
                for (String next : nexts) {
                    if (invalid.add(next)) {
                        q.offer(next);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private List<String> getNexts(String s) {
        List<String> res = new ArrayList<>();

        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            res.add(getPlusOne(chs, i));
            res.add(getMinusOne(chs, i));
        }

        return res;
    }

    private String getPlusOne(char[] chs, int idx) {
        char c = chs[idx];

        chs[idx] = (char) ('0' + ((c - '0') + 1) % 10);
        String res = new String(chs);

        chs[idx] = c;

        return res;

    }

    private String getMinusOne(char[] chs, int idx) {
        char c = chs[idx];

        chs[idx] = (char) ('0' + ((c - '0') - 1 + 10) % 10);
        String res = new String(chs);

        chs[idx] = c;

        return res;
    }
}
