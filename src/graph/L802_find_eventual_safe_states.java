package graph;

import java.util.ArrayList;
import java.util.List;

public class L802_find_eventual_safe_states {

    // state[i] == 0: unvisited
    // state[i] == 1: safe
    // state[i] == 2: unsafe

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }

        int nodeCount = graph.length;
        int[] states = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if(isSafe(graph, i, states)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isSafe(int[][] graph, int start, int[] states){
        if(states[start] != 0) {
            return states[start] == 1;
        }

        states[start] = 2;

        for (int next : graph[start]){
            if(!isSafe(graph, next, states)) {
                return false;
            }
        }

        states[start] = 1;

        return true;
    }
}
