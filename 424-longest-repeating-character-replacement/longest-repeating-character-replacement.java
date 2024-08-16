class Solution {
    public int characterReplacement(String s, int k) {
     int[] count = new int[26]; // Array to store the frequency of each character
        int maxCount = 0; // To track the highest frequency of any character in the current window
        int maxLength = 0; // The length of the longest valid window
        int left = 0; // Left pointer of the window

        for (int right = 0; right < s.length(); right++) { // Right pointer of the window
            // Increase the frequency of the current character in the window
            count[s.charAt(right) - 'A']++;

            // Update the maximum frequency of any character in the current window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If the window is invalid (more replacements needed than allowed)
            if (right - left + 1 - maxCount > k) {
                // Move the left pointer to shrink the window
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Calculate the length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // The length of the longest valid window
    }
}