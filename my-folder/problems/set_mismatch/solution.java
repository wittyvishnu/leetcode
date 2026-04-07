class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int repeat=0;
        int actualSum=(n*(n+1))/2;
        int sum=nums[n-1];
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1])repeat=nums[i];
            sum+=nums[i];
        }
        sum=sum-repeat;
        return new int[]{repeat,actualSum-sum};
    }
}