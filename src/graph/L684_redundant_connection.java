package graph;

public class L684_redundant_connection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];


        for (int[] edge : edges) {
            int u = find(roots, edge[0]);
            int v = find(roots, edge[1]);
            if (u == v) {
                return edge;
            }
            roots[u] = v;
        }

        return new int[0];
    }

    private int find(int[] roots, int node) {

        if (roots[node] == 0) {
            return node;
        } else {
            int currentNode = find(roots, roots[node]);
            roots[node] = currentNode;

            return roots[node];
        }
    }
}
