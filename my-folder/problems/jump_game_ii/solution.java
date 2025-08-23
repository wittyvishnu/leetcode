class Solution {
    public int jump(int[] nums) {
       int jumps=0;
       int n=nums.length-1;
       int i=0;
       while(i<n){
        if(nums[i]>=n-i){
            jumps++;
            return jumps;
        }
        else{
            int temp=i+1;
            for (int j = i + 2; j <= i + nums[i] && j < nums.length; j++) {
                if (j + nums[j] >= temp + nums[temp]) {
                    temp = j;
                }
            }
            i=temp;
            jumps++;
        }
       }
       return jumps;

    }
}