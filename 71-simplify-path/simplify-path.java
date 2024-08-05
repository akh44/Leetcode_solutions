class Solution {
    public String simplifyPath(String path) {
       // Split the input path by '/'
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty and current directory components
                continue;
            } else if (component.equals("..")) {
                // Pop from stack if possible (move up a directory)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory names onto the stack
                stack.push(component);
            }
        }
        
        // Build the simplified path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        
        // Return the simplified path, or "/" if the stack is empty
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}