class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nextS=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[i]<=heights[st.peek()])
            st.pop();
            nextS[i]=st.isEmpty()?n:st.peek();
            st.push(i); 
        }
        st.clear();
        int max=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[i]<=heights[st.peek()])
            st.pop();
            int prevS=st.isEmpty()?-1:st.peek();
            st.push(i);
            int width=nextS[i]-prevS-1;
            max=Math.max(max,width*heights[i]);

        }
        return max;

    }
}