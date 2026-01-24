class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1=new Stack();
        st2=new Stack();
    }
    
    public void push(int x){
            st1.push(x);
    }
    
    public int pop() {
        int temp=-1;
        int n=st1.size();
        for(int i=1;i<n;i++)
        st2.push(st1.pop());
        temp=st1.pop();
        n=st2.size();
        for(int i=1;i<=n;i++)
        st1.push(st2.pop());
        return temp;
    }
    
    public int peek() {
        int temp=-1;
        int n=st1.size();
        for(int i=1;i<=n;i++){
        temp=st1.pop();
        st2.push(temp);
        }
        n=st2.size();
        for(int i=1;i<=n;i++)
        st1.push(st2.pop());
        return temp;
    }
    
    public boolean empty() {
        if(st1.isEmpty())return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */