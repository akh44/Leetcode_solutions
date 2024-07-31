class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length <= 2) {
            return nums.length;
        }

        int k = 1;  // The index where we place the next valid element
        int count = 1;  // Counter for occurrences of the current element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}