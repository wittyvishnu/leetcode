class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();

        
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;

     
        return (i == sb.length()) ? "0" : sb.substring(i);
    }
}
