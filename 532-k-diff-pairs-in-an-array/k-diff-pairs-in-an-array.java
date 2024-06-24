class Solution {
    public int findPairs(int[] nums, int k) {
        
        if (k < 0) return 0; // Absolute difference cannot be negative
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (set.contains(num - k) && !pairs.contains(num - k)) {
                count++;
                pairs.add(num - k);
            }
            if (set.contains(num + k) && !pairs.contains(num)) {
                count++;
                pairs.add(num);
            }
            set.add(num);
        }

        return count;
}
}