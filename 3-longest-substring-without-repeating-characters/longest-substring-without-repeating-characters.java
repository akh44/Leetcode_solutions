class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // Maximum length of substring without repeating characters
        Set<Character> seenChars = new HashSet<>(); // Set to store characters in the current window

        for (int right = 0; right < n; right++) {
            // If the character is already in the set, remove characters from the left
            while (seenChars.contains(s.charAt(right))) {
                seenChars.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to the set and update the maximum length
            seenChars.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}