class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int dominant=0;
        int total=nums[n-1];
        int count=1;
        for(int i=n-2;i>=0;i--){
            if((double)nums[i]>((double)total/(double)count))
                dominant++;
            total+=nums[i];
            count++;
        }
        return dominant;
        
    }
}