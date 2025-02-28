class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int totalSum = 0;

        // Step 1: Compute total sum of all numbers
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Check if (totalSum + target) is even and feasible
        if ((totalSum + target) % 2 != 0 || totalSum < Math.abs(target)) {
            return 0; // No valid subsets possible
        }

        // Step 3: We are looking for subsets with this target sum
        int subsetSum = (totalSum + target) / 2;

        // Step 4: Create a dp array where dp[j] = number of ways to form sum j
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // Base case: 1 way to form sum 0 (empty subset)

        // Step 5: Process each number in nums
        for (int num : nums) {
            // Step 6: For each valid target sum j, update dp[j] using dp[j - num]
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // Step 7: Final answer is number of ways to form subsetSum
        return dp[subsetSum];
    }
}