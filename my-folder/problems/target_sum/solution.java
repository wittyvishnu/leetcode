class Solution {
    int n;
    int ways=0;
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        checkAll(nums,target,0,0);
        return ways;

    }
    public void checkAll(int[] nums,int target,int index,int sum){
        if(index==n){
            if(sum==target)
            ways++;
            return;
        }
        checkAll(nums,target,index+1,sum+nums[index]);
        checkAll(nums,target,index+1,sum-nums[index]);

    }
}