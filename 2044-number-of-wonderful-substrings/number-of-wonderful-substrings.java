class Solution {
    public long wonderfulSubstrings(String word) {

         Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // Base case: empty prefix has even count for all

        int mask = 0;
        long result = 0;

        for (char ch : word.toCharArray()) {
            int bit = ch - 'a';         // Map 'a' to 0, 'b' to 1, ..., 'j' to 9
            mask ^= (1 << bit);         // Flip the bit at that position in the mask

            // Case 1: Check if this mask was seen before (all characters even)
            result += freq.getOrDefault(mask, 0);

            // Case 2: Flip each bit once and check (only one character has odd freq)
            for (int i = 0; i < 10; i++) {
                int testMask = mask ^ (1 << i);
                result += freq.getOrDefault(testMask, 0);
            }

            // Store the current mask
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }

        return result;
        
    }
}