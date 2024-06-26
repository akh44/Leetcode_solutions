class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store the prefix sum frequencies
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        // Initialize with prefix sum 0 having frequency 1
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num; // Update current prefix sum

            // Check if (currentSum - k) exists in the hash map
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the hash map with the current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}