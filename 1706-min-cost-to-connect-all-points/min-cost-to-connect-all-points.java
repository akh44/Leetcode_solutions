class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n]; // Tracks visited nodes
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // Min-heap to store edges
        minHeap.offer(new int[]{0, 0}); // Start from any node, cost is 0
        int totalCost = 0;
        int nodesConnected = 0;

        while (nodesConnected < n) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int node = current[1];

            if (visited[node]) continue; // Ignore if already in MST

            visited[node] = true;
            totalCost += cost;
            nodesConnected++;

            // Add all unvisited neighbors to the heap
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    minHeap.offer(new int[]{distance, i});
                }
            }
        }

        return totalCost;
    }
}