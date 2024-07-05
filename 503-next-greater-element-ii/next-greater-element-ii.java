public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        // Initialize all elements in ans as -1
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        // Traverse the array twice to handle the circular nature
        for (int i = 0; i < 2 * n; i++) {
            while (!stk.isEmpty() && nums[i % n] > nums[stk.peek()]) {
                ans[stk.pop()] = nums[i % n];
            }
            if (i < n) {
                stk.push(i);
            }
        }

        return ans;
    }

    
    
}
