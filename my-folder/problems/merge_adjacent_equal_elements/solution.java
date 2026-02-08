class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n=nums.length;
        List<Long> ans=new ArrayList<>();
        Stack<Long> st=new Stack();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push((long)nums[i]);
                continue;
            }
            if(st.peek()==(long)nums[i]){
                long temp=2*st.pop();
                while(!st.isEmpty()&&temp==st.peek())
                    temp=2*st.pop();
                st.push(temp);
            }else
                st.push((long)nums[i]);
        }
        while(!st.isEmpty()){
            ans.add(0,st.pop());
        }
        return ans;
        
    }
}