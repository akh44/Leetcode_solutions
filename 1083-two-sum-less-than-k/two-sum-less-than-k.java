class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
       Arrays.sort(nums);  // Sort the array to apply two-pointer technique
        int i = 0;
        int j = nums.length - 1;
        int max_sum = -1;  // Start with -1 to indicate no valid sum found if none exists

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum < k) {
                // Update max_sum if the current sum is the highest valid sum found
                max_sum = Math.max(max_sum, sum);
                i++;  // Try to increase sum by moving the left pointer
            } else {
                j--;  // Try to decrease sum by moving the right pointer
            }
        }

        return max_sum;
}
}