import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // If source and destination are the same, path trivially exists
        if (source == destination) return true;

        // Build adjacency list for the undirected graph
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);  // because the graph is bidirectional
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited,
                        int node, int destination) {
        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (dfs(graph, visited, nei, destination)) {
                    return true;  // early exit if path found
                }
            }
        }
        return false;
    }
}