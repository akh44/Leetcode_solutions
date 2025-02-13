class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Step 2: Min-Heap (Priority Queue) to store (time, node)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, k});  // (current time, start node)

        // Step 3: Distance Map to track the shortest time to each node
        Map<Integer, Integer> shortestTime = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0], node = curr[1];

            // If node is already processed with a smaller time, skip it
            if (shortestTime.containsKey(node)) continue;

            shortestTime.put(node, time);  // Set shortest time

            // Process neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], travelTime = neighbor[1];
                    if (!shortestTime.containsKey(nextNode)) {
                        minHeap.add(new int[]{time + travelTime, nextNode});
                    }
                }
            }
        }

        // Step 4: If all nodes are reached, return max time; otherwise, return -1
        if (shortestTime.size() != n) return -1;
        
        return Collections.max(shortestTime.values());
        
    }
}