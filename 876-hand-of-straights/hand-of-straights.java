class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
     if (hand.length % groupSize != 0) return false; // Quick check for invalid cases
        
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        
        // Step 1: Count occurrences of each card
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        // Step 2: Try to create groups
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count > 0) { // If there are cards available
                for (int i = 0; i < groupSize; i++) {
                    int nextCard = key + i;
                    if (countMap.getOrDefault(nextCard, 0) < count) {
                        return false; // Not enough cards to form a group
                    }
                    countMap.put(nextCard, countMap.get(nextCard) - count);
                }
            }
        }
        
        return true;
    }
}