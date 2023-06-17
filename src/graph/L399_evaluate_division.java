package graph;

import java.util.*;

public class L399_evaluate_division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> roots = new HashMap<>();  //<node, roots of the node>
        Map<String, Double> ratio = new HashMap<>();   //<node, node / roots>
        for (int i = 0; i < equations.size(); i++) {
            union(roots, ratio, equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            if (!roots.containsKey(s1) || !roots.containsKey(s2)
                    || !find(roots, ratio, s1).equals(find(roots, ratio, s2))) {
                res[i] = -1.0;
            } else {
                res[i] = ratio.get(s1) / ratio.get(s2);
            }
        }
        return res;
    }

    private void union(Map<String, String> roots, Map<String, Double> ratio, String s1, String s2, double val) {
        if (!roots.containsKey(s1)) {
            roots.put(s1, s1);
            ratio.put(s1, 1.0);
        }
        if (!roots.containsKey(s2)) {
            roots.put(s2, s2);
            ratio.put(s2, 1.0);
        }
        String p1 = find(roots, ratio, s1);
        String p2 = find(roots, ratio, s2);
        roots.put(p1, p2);
        ratio.put(p1, val * ratio.get(s2) / ratio.get(s1));
    }

    private String find(Map<String, String> roots, Map<String, Double> ratio, String s) {
        if (s.equals(roots.get(s))) {
            return s;
        }
        String parent = roots.get(s);
        String ancestor = find(roots, ratio, parent);
        roots.put(s, ancestor);
        ratio.put(s, ratio.get(s) * ratio.get(parent));
        return ancestor;
    }
}
