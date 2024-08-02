 class Solution {
    public boolean canJump(int[] nums) {
         int maxReach = 0;  // the furthest index we can reach so far

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the furthest reach, return false
            if (i > maxReach) {
                return false;
            }
            // Update the furthest reach
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
 }