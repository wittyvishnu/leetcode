class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums)
        sum+=num;
        if(sum%2==1)return false;
        
        return  isSubsetSum(nums,sum/2);

    }
    public boolean isSubsetSum(int[] nums,int sum){
        int n=nums.length;
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=1;i<sum+1;i++)
        if(i==nums[0])dp[0][i]=true;

        for(int i=0;i<n;i++)
        dp[i][0]=true;

        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean notTaken=dp[i-1][j];
                boolean take=(j >= nums[i]) && dp[i-1][j-nums[i]];
                
                dp[i][j]= take|| notTaken;
            }
        }
          return dp[n-1][sum];
    }
}
