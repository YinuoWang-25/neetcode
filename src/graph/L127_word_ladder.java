package graph;

import java.util.*;

public class L127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        Deque<String> q = new LinkedList<>();
        q.offerLast(beginWord);

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.pollFirst();
                if (cur.equals(endWord)) {
                    return step;
                }

                List<String> nexts = getNexts(cur, dict);
                for (String next : nexts) {
                    q.offerLast(next);
                    dict.remove(next);
                }
            }
            step++;
        }

        return 0;
    }

    private List<String> getNexts(String str, Set<String> dict) {
        List<String> res = new ArrayList<>();

        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char origin = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == chs[i])
                    continue;
                chs[i] = c;

                if (dict.contains(new String(chs))) {
                    res.add(new String(chs));
                }
            }
            chs[i] = origin;
        }

        return res;
    }
}
