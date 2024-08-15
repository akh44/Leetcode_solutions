class Solution {
    public int search(int[] nums, int target) {
            int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low +high) / 2;
            
            // If the target is found
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // If the target is within the range of the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Search in the left half
                } else {
                    low = mid + 1; // Search in the right half
                }
            } 
            // If the right half is sorted
            else {
                // If the target is within the range of the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
            }
        }
        
        // If the target is not found
        return -1;
    
    }
}