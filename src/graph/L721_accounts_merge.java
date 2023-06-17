package graph;

import java.util.*;

public class L721_accounts_merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 1. deal with corner case
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }

        /**
         * How we build the union find tree: Two name with same email should Have the
         * same parent - which indicate that they are the same account
         */
        int[] parents = new int[accounts.size()];
        findParents(accounts, parents);

        /**
         * For every root parent (actual user), find all email address for them
         */
        Map<Integer, Set<String>> emailMap = getEmails(accounts, parents);

        /**
         * Build the final results
         */
        for (Integer nameIndex : emailMap.keySet()) {
            List<String> cur = new ArrayList<>();
            cur.add(accounts.get(nameIndex).get(0));
            cur.addAll(new ArrayList<>(emailMap.get(nameIndex)));
            res.add(cur);
        }

        return res;
    }

    private Map<Integer, Set<String>> getEmails(List<List<String>> accounts, int[] parents) {
        Map<Integer, Set<String>> emailMap = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            int root = find(parents[i], parents);
            emailMap.putIfAbsent(root, new TreeSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailMap.get(root).add(accounts.get(i).get(j));
            }
        }

        return emailMap;
    }

    // find parents for every name id based on emails
    private void findParents(List<List<String>> accounts, int[] parents) {
        Map<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            if (account.size() <= 1)
                continue;

            for (int j = 1; j < account.size(); j++) {
                if (indices.containsKey(account.get(j))) {
                    union(indices.get(account.get(j)), i, parents);
                } else {
                    indices.put(account.get(j), i);
                }
            }
        }
    }

    private void union(int a, int b, int[] parents) {
        parents[find(a, parents)] = find(b, parents);
    }

    private int find(int a, int[] parents) {
        if (parents[a] == a)
            return a;
        parents[a] = find(parents[a], parents);
        return parents[a];
    }
}