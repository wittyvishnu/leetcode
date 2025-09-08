class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer>  map=new HashMap();
        for(int i=0;i<nums.length;i++) 
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int index=0;
        for(int i=0;i<3;i++)
            if(map.containsKey(i))
                for(int j=0;j<map.get(i);j++)
                nums[index++]=i;
        
    
        
    }
}