class Solution {
    public boolean canPartition(int[] nums) {
         int sum = Arrays.stream(nums).sum();

        // If sum is odd, we cannot partition into equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: subset sum of 0 is always possible

        // Process each number in nums
        for (int num : nums) {
            // Iterate in reverse to avoid using the same element multiple times
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num]; // If sum `j-num` is possible, then sum `j` is also possible
            }
        }

        return dp[target]; // If `t
    }
}