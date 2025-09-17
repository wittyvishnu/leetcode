class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countStore=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]==1)countStore++;
          else{
            count=Math.max(count,countStore);
            countStore=0;
          }
        }
        count=Math.max(count,countStore);
        return count;
    }
}