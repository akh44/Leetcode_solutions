class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[] cost = new int[n]; 
        Arrays.fill(cost, Integer.MAX_VALUE); // Initialize all costs as infinity
        cost[src] = 0; // Starting point

        // Perform k+1 relaxations
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n); // Copy previous state
            
            // Relax all edges
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (cost[from] != Integer.MAX_VALUE) { // Only relax if from-city is reachable
                    temp[to] = Math.min(temp[to], cost[from] + price);
                }
            }
            
            cost = temp; // Update cost array for the next iteration
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}