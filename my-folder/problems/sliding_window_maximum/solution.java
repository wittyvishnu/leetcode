class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq= new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&& nums[dq.peekLast()]<=nums[i])
            dq.pollLast();
            dq.offer(i);
            if(i+1>=k){
                while(!dq.isEmpty() && dq.peek()<i+1-k)
                dq.poll();
                ans[idx++]=nums[dq.peek()];

            }
        }
        return ans;


        
    }
}