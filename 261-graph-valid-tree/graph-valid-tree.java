class Solution {
    public boolean validTree(int n, int[][] edges) {
            // Step 1: Check the number of edges
        if (edges.length != n - 1) return false;

        // Step 2: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 3: Traverse the graph using DFS
        boolean[] visited = new boolean[n];
        if (hasCycle(graph, visited, 0, -1)) return false;

        // Step 4: Ensure all nodes are visited
        for (boolean v : visited) {
            if (!v) return false; // If a node is unvisited, the graph is disconnected
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, neighbor, node)) return true;
            } else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }

        return false;
    }
    }
