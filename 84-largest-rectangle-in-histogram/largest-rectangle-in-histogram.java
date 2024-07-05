class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n]; // next smaller element indexes
        int[] pse = new int[n]; // previous smaller element indexes
        Stack<Integer> stk = new Stack<>();
        
        // Find next smaller element for each bar
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                nse[stk.pop()] = i;
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            nse[stk.pop()] = n;
        }
        
        // Find previous smaller element for each bar
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                pse[stk.pop()] = i;
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            pse[stk.pop()] = -1;
        }
        
        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
