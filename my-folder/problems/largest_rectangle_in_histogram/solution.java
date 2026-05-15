class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        if(n==1)return heights[0];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            st.pop();
            if(!st.isEmpty())
            prev[i]=st.peek();
            else
            prev[i]=-1;
            st.push(i);
        }
        st.clear(); 
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            st.pop();
            if(!st.isEmpty())
            next[i]=st.peek();
            else
            next[i]=n;
            st.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(next[i]-prev[i]-1));
        }
        return max;

        

    }
}