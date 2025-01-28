class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Step 1: Create a DP array to store the minimum cost to reach each step
        int[] dp = new int[n];
        
        // Step 2: Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Step 3: Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Step 4: Return the minimum cost to reach the top
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}