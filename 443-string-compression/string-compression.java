class Solution {
    public int compress(char[] chars) {
    int write = 0; // Pointer to write compressed string
    int read = 0;  // Pointer to read the original string
    
    while (read < chars.length) {
        char currentChar = chars[read];
        int count = 0;
        
        // Count the number of consecutive repeating characters
        while (read < chars.length && chars[read] == currentChar) {
            read++;
            count++;
        }
        
        // Write the character
        chars[write++] = currentChar;
        
        // If the count is more than 1, write the count as well
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[write++] = c;
            }
        }
    }

        return write;
    }
    
}
