class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int zeros=0;
        for(int num:nums)
        if(num==0)zeros++;
        else product*=num;
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0 && zeros-1==0)
            ans[i]=product;
            else if(nums[i]!=0 && zeros==0)
            ans[i]=product/nums[i];
          
        }
        return ans;
        
    }
}