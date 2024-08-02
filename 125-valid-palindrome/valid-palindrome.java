class Solution {
    public boolean isPalindrome(String s) {
              // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int i = 0;
        int j = s.length() - 1;

        // Compare characters from both ends towards the center
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false; // Mismatch found
            }
            i++;
            j--;
        }
        return true; // No mismatches found
         
    }
}