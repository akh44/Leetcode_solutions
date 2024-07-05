class Solution {
    public boolean isValid(String s) {
        // create a stack to store opening parentheses
        Stack<Character> stack = new Stack<>();
        
        // loop through the string
        for (int i = 0; i < s.length(); i++) {
            // get the current character
            char c = s.charAt(i);
            
            // if the current character is an opening parentheses
            if (c == '(' || c == '{' || c == '[') {
                // push it onto the stack
                stack.push(c);
            }
            // if the current character is a closing parentheses
            else if (c == ')' || c == '}' || c == ']') {
                // if the stack is empty, return false
                if (stack.isEmpty()) {
                    return false;
                }
                // pop the top element from the stack
                char top = stack.pop();
                // if the current character and the top element from the stack don't match, return false
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        // if the stack is not empty at the end, return false
        if (!stack.isEmpty()) {
            return false;
        }
        // return true
        return true;
    }
}