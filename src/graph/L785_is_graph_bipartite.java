package graph;

public class L785_is_graph_bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] !=0 ) continue;

            if (!dfs(colors, graph, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] colors, int[][] graph, int i, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }

        colors[i] = color;

        for (int next : graph[i]) {
            boolean cur = dfs(colors, graph, next, -color);
            if (!cur) {
                return false;
            }
        }
        return true;
    }
}
