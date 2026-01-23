import java.util.Stack;

class MinStack {
    Stack<Long> st;   
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;
        if (st.isEmpty()) {
            st.push(v);
            min = v;
        } else if (v < min) {
            st.push(2 * v - min); 
            min = v;
        } else {
            st.push(v);
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();
        if (top < min) {
            min = 2 * min - top; 
        }
    }
    
    public int top() {
        if (st.isEmpty()) return -1; 
        if (st.peek() < min) {
            return (int) min;
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        if (st.isEmpty()) return -1; 
        return (int) min;
    }
}
