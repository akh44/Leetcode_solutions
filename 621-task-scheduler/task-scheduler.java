class Solution {
    public int leastInterval(char[] tasks, int n) {
         // Step 1: Count frequencies of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Step 3: Count tasks with the maximum frequency
        int maxFreqCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        // Step 4: Calculate the minimum time
        int intervals = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // Step 5: Return the maximum of total tasks or calculated intervals
        return Math.max(intervals, tasks.length);
    }
}