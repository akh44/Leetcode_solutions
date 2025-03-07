public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
         int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n
            int bit = n & 1;
            // Shift result to the left and add the extracted bit
            result = (result << 1) | bit;
            // Shift n to the right
            n >>= 1;
        }
        return result;
    }
}