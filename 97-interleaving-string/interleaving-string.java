class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
         int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) return false;

        // 1D dp array
        boolean[] dp = new boolean[m + 1];

        // Base case - empty strings interleave to form empty string
        dp[0] = true;

        // Fill first row (only s2 contributes)
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            // First column (only s1 contributes)
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);

                dp[j] = (c1 == c3 && dp[j]) || (c2 == c3 && dp[j - 1]);
            }
        }

        return dp[m];
    }
}