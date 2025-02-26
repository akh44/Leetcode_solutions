class Solution {
    public int change(int amount, int[] coins) {
           int n = coins.length;
        int[] dp = new int[amount + 1];

        // Base case: There's exactly one way to make amount 0 (by using no coins).
        dp[0] = 1;

        // Process each coin one by one
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}