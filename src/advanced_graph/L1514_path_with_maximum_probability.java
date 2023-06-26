package advanced_graph;

import java.util.*;

public class L1514_path_with_maximum_probability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], succProb[i]);
            graph.putIfAbsent(edge[1], new HashMap<>());
            graph.get(edge[1]).put(edge[0], succProb[i]);
        }


        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double[] probs = new double[n];
        pq.offer(new double[]{1, start_node});
        while (!pq.isEmpty()) {

            double[] cur = pq.poll();
            int v = (int)cur[1];
            if (v == end_node) {
                return cur[0];
            }
            if (cur[0] > probs[v]) {
                probs[v] = cur[0];

                if (!graph.containsKey(v)) continue;
                Map<Integer, Double> nexts = graph.get(v);
                for (Integer next : nexts.keySet()) {
                    pq.offer(new double[]{cur[0] * nexts.get(next), next});
                }

            }
        }

        return 0d;
    }
}
