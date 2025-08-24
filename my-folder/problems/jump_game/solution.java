class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length-1;
        int maxindex=0;
        for(int i=0;i<=n;i++){
            if(maxindex>=n)return true;
            if(i>maxindex)return false;
            maxindex=(i+nums[i]>maxindex)?i+nums[i]:maxindex;
        
        }
        return true;
    }
}