class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
         boolean found_x = false, found_y = false, found_z = false;
        
        for (int[] triplet : triplets) {
            // Ignore triplets that exceed the target in any dimension
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            // Check if this triplet contributes to the target
            if (triplet[0] == target[0]) found_x = true;
            if (triplet[1] == target[1]) found_y = true;
            if (triplet[2] == target[2]) found_z = true;

            // If we have found all three components, return true early
            if (found_x && found_y && found_z) return true;
        }
        
        return false;
    }
}