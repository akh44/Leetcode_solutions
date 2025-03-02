class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        
        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting empty string to non-empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // All deletions
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // All insertions
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match — no new operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Characters don't match — try insert, delete, or replace
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + 1,        // Delete from word1
                        Math.min(
                            dp[i][j - 1] + 1,    // Insert into word1
                            dp[i - 1][j - 1] + 1 // Replace
                        )
                    );
                }
            }
        }

        // Final answer
        return dp[m][n];
        
    }
}