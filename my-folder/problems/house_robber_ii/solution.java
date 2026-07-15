class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(construct(nums,0,n-2),construct(nums,1,n-1));
    }
    public int construct(int[] nums,int start,int end){
        int n=end-start+2;
        if(start==end)return nums[start];
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=nums[start];
        int idx=2;
        for(int i=start+1;i<=end;i++){
        dp[idx]=Math.max(dp[idx-1],dp[idx-2]+nums[i]);
        idx++;
        }
        return dp[idx-1];
    }

}