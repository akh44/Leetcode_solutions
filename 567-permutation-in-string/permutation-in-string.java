public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays for s1 and the current window in s2
        int[] freqS1 = new int[26];
        int[] freqWindow = new int[26];

        // Populate the frequency array for s1
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length(); i++) {
            // Add the current character to the window
            freqWindow[s2.charAt(i) - 'a']++;

            // Remove the leftmost character if the window size exceeds s1's length
            if (i >= s1.length()) {
                freqWindow[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Compare the frequency arrays
            if (Arrays.equals(freqS1, freqWindow)) {
                return true; // Found a permutation of s1 in s2
            }
        }

        return false; // No permutation found
    }
}