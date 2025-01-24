class Solution {
    public boolean validTree(int n, int[][] edges) {
            // Step 1: Check the number of edges
        if (edges.length != n - 1) return false;

        // Step 2: Initialize Union-Find structure
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step 3: Process all edges
        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);

            // If two nodes have the same root, there's a cycle
            if (rootA == rootB) return false;

            // Union the two nodes
            parent[rootA] = rootB;
        }

        return true;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node];
    }
    }
