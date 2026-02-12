class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums)
        sum+=num;
        if(sum%2==1)return false;
        Boolean[][] dp=new Boolean[n][sum+1];
        return  isSubsetSum(nums,n-1,sum/2,dp);

    }
    public boolean isSubsetSum(int[] nums,int index,int target,Boolean[][] dp){
        if(target==0)return true;
        if(index==0)return target==nums[0];
        if(dp[index][target]!=null)
        return dp[index][target];
        boolean notTaken=isSubsetSum(nums,index-1,target,dp);
        boolean taken=false;
        if(nums[index]<=target)
        taken=isSubsetSum(nums,index-1,target-nums[index],dp);
        dp[index][target]=notTaken||taken;
        return dp[index][target];
    }
}
