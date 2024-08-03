class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       
        int n = nums.length;
        int minLength = Integer.MAX_VALUE; // To track the minimum length
        int sum = 0; // To keep track of the current sum
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // Add the current element to the sum

            // Shrink the window from the left while the sum is greater than or equal to target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // Update the minimum length
                sum -= nums[left]; // Subtract the left element from the sum
                left++; // Move the left pointer to the right
            }
        }

        // If minLength was updated, return it, otherwise return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}