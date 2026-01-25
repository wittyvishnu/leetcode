class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        if (k >= n) return "0";

        Deque<Integer> dq = new ArrayDeque<>();

        // Monotonic increasing stack
        for (char c : num.toCharArray()) {
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > c-'0') {
                dq.pollLast();
                k--;
            }
            dq.addLast(c-'0');
        }

        // Remove remaining digits from end
        while (k > 0) {
            dq.pollLast();
            k--;
        }
        while(!dq.isEmpty()&&dq.peekFirst()==0)
        dq.pollFirst();
        StringBuilder sb = new StringBuilder();
        for (int c : dq) 
        sb.append(c);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
