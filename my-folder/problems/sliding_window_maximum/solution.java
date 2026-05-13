class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq= new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i])
            dq.pollLast();
            dq.addLast(i);
            if(i>=k-1){
                while(dq.peekFirst()<i-k+1)
                dq.pollFirst();
                ans[idx++]=nums[dq.peekFirst()];

            
            }

        }
        return ans;


        
    }
}