class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
         for (int i = 1; i < nums.length; i++) {
            int tempMax=Math.max(nums[i],Math.max(maxProd*nums[i],minProd*nums[i]));
            int tempMin=Math.min(nums[i],Math.min(maxProd*nums[i],minProd*nums[i]));
            maxProd=tempMax;
            minProd=tempMin;
            ans=Math.max(maxProd,ans);
         }
         return ans;
    }
}