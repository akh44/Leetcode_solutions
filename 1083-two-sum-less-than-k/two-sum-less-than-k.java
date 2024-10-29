class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
       Arrays.sort(nums);  
        int i = 0;
        int j = nums.length - 1;
        int max_sum = -1;  

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum < k) {
                
                max_sum = Math.max(max_sum, sum);
                i++;  
            } else {
                j--;  
            }
        }

        return max_sum;
}
}