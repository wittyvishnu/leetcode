class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n=nums.length;
       int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int j=1;j<=2;j++)
        for(int i=n-1;i>=0;i--){
         while(!st.isEmpty()&&nums[i]>=st.peek())
         st.pop();
         if(j==2)
         res[i]=st.isEmpty() ? -1 : st.peek();
         st.push(nums[i]);
        }
        return res;
       
    }
}