class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Set<Integer> cs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            cs.add(nums[i]);
        }
        int ans=0;
        for(int num:cs){
            if(!cs.contains(num-1)){
                int length=1;
                int currentNum=num+1;
                while(cs.contains(currentNum)){
                    currentNum++;
                    length++;
                }
                ans=Math.max(length,ans);
            }
        }
        return ans;
    }
}