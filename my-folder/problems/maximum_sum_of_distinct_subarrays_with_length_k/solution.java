class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        long sum=0;
        long maxsum=0;
        HashSet<Integer> set=new HashSet<>();
        for(int r=0;r<n;r++){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            set.add(nums[r]);
            sum+=nums[r];
            if(r-l+1==k){
                maxsum=Math.max(maxsum,sum);
                set.remove(nums[l]);
                sum-=nums[l];
                l++;

            }

        }
        return maxsum;

    }
}