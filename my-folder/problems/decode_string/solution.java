import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c); // push everything except ']'
            } else {
                // Step 1: get substring inside [ ... ]
                StringBuilder substring = new StringBuilder();
                while (stack.peek() != '[') {
                    substring.insert(0, stack.pop());
                }
                stack.pop(); // remove '['

                // Step 2: get number before '['
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numStr.insert(0, stack.pop());
                }
                int repeat = Integer.parseInt(numStr.toString());

                String expanded = substring.toString().repeat(repeat);
                for (char ch : expanded.toCharArray()) {
                    stack.push(ch);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : stack) ans.append(ch);
        
        return ans.toString();
    }
}