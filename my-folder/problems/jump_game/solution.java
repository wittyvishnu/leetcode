class Solution {
    public boolean canJump(int[] nums) {
        int l=0,r=0;
        int farthest=0;
        int n=nums.length;
        while(r<n){
            for(int i=l;i<=r;i++)
            farthest=Math.max(farthest,i+nums[i]);
            if(r==farthest)break;
            l=r+1;
            r=farthest;
        }
        if(farthest>=n-1)return true;
        return false;
    }
}