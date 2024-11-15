class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> stack = new Stack<>(); // Stack to store indices of unresolved days
        int n = temperatures.length;
        int[] res = new int[n]; // Result array initialized to 0 by default

        for (int i = n - 1; i >= 0; i--) { // Traverse from right to left
            // Pop indices from the stack where temperature is less than or equal to current day's temperature
     while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // If stack is not empty, calculate the difference in days
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        return res;
    }
}