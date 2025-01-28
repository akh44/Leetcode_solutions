class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1; // Base case for 1 step
        
        // Initialize the dp array
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at step 0
        dp[1] = 1; // 1 way to reach step 1

        // Fill the dp array for steps 2 to n
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the result for step n
        return dp[n];
    }
}