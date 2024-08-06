class Solution {
    public int calculate(String s) {

         Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 means positive, -1 means negative
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // Forming the number
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1; // Update sign for next number
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1; // Update sign for next number
            } else if (c == '(') {
                // Push the result and the sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Calculate the sub-expression result
                result += sign * number;
                number = 0;
                // Pop the sign and the previous result
                result *= stack.pop(); // stack.pop() is the sign
                result += stack.pop(); // stack.pop() is the previous result
            }
        }
        
        // Add the last number if any
        result += sign * number;
        
        return result;
        
    }
}