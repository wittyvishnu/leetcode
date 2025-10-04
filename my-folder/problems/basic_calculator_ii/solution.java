class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
               
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') stack.push(current);
                else if (op == '-') stack.push(-current);
                else if (op == '*') stack.push(stack.pop() * current);
                else if (op == '/') stack.push(stack.pop() / current);

                op = c;        
                current = 0;   
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();
        return sum;
    }
}
