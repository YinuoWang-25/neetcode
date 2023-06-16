package graph;

import java.util.*;

public class L399_evaluate_division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            graph.putIfAbsent(equations.get(i).get(0), new ArrayList<>());
            graph.putIfAbsent(equations.get(i).get(1), new ArrayList<>());
            graph.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            graph.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1))) {
                res[i] = -1;
            } else {
                Double tmp = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
                res[i] = tmp == null ? -1 : tmp;
            }
        }
        return res;
    }

    private Double dfs(String cur, String second, Map<String, List<Pair>> graph, Set<String> visited) {
        if (cur.equals(second)) {
            return 1.0;
        }

        if (visited.contains(cur)) {
            return null;
        }

        visited.add(cur);

        List<Pair> nexts = graph.get(cur);
        for (Pair next : nexts) {
            Double tmp = dfs(next.str, second, graph, visited);
            if (tmp != null) {
                visited.remove(cur);
                return next.val * tmp;
            }
        }

        visited.remove(cur);
        return null;
    }

    class Pair {
        String str;
        double val;

        public Pair(String s, double val) {
            this.str = s;
            this.val = val;
        }
    }
}
