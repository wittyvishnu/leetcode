class StockSpanner {
     Stack<List<Integer>> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int val=1;
        List<Integer> stock=new ArrayList<>(2);
        stock.add(price);
        if(st.isEmpty()){
            stock.add(val);
            st.push(stock);
            return val;
        }
        while(!st.isEmpty()&&price>=st.peek().get(0)){
            val+=st.pop().get(1);
        }
        stock.add(val);
        st.push(stock);
        return val;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */