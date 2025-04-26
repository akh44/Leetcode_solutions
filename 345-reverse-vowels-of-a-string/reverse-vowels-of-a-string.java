class Solution {
    public String reverseVowels(String s) {
          Set<Character> vowels = new HashSet<>();
        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowels.add(ch);
        }

        // Convert string to character array (since string is immutable)
        char[] chars = s.toCharArray();
        
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            // Move left pointer until it finds a vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer until it finds a vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Now both chars[left] and chars[right] are vowels -> swap them
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        // Convert character array back to string
        return new String(chars);
    }
}