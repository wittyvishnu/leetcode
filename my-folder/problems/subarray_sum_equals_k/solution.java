class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k)count++;
            if(map.containsKey(sum-k))
            count+=map.get(sum-k).size();
            if(!map.containsKey(sum))
            map.put(sum,new ArrayList<>());
            map.get(sum).add(i);

        }
        return count;
    }
}