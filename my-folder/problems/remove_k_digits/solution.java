class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(char ch:num.toCharArray()){
            int n=ch-'0';
            while(!dq.isEmpty()&&k>0&&dq.peekLast()>n){
                dq.pollLast();
                k--;
            }
            dq.addLast(n);
        }
        StringBuilder sb=new StringBuilder();
         while (k > 0 && !dq.isEmpty()) {
            dq.pollLast();
            k--;
        }
        
        while (!dq.isEmpty() && dq.peekFirst() == 0) {
            dq.pollFirst();
        }
        
        while(!dq.isEmpty())
        sb.append(dq.pollFirst());
        
        return sb.length()>0?sb.toString():"0";
    }
}