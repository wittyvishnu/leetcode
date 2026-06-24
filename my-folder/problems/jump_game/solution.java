class Solution {
    public boolean canJump(int[] nums) {
        int maxJump=0;
        int i=0;
        int n=nums.length;
        while(i<=maxJump&&i<n){
            maxJump=Math.max(maxJump,i+nums[i]);
            i++;
        }
        if(maxJump>=n-1) return true;
        return false;
        
    }
}