class StockSpanner {
    Stack<int[]> st;
    int index=0;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[0]<=price)
        st.pop();
        int temp=(st.isEmpty())?index+1:index-st.peek()[1];
        st.push(new int[]{price,index});
        index++;
        return temp;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */