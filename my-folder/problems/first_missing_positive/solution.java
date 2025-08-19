class Solution {
    public int firstMissingPositive(int[] nums) {
     int n=nums.length;
      boolean[] arr=new boolean[n+1];
      for(int i=0;i<n;i++){
        if(nums[i]>0 && nums[i]<=n){
            arr[nums[i]]=true;
        }
      }
      for(int i=1;i<=n;i++){
        if(!arr[i]) return i;
      }
     return n+1;
    }
}