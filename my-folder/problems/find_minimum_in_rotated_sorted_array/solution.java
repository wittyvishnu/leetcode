class Solution {
    public int findMin(int[] nums) {
        int ans=5000;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(nums[low]<=nums[mid]){
                ans=ans>nums[low]?nums[low]:ans;
                low=mid+1;
            }else{
                 ans=ans>nums[mid]?nums[mid]:ans;
                 high=mid-1;
                
            }
        }
            return ans;
    }
}