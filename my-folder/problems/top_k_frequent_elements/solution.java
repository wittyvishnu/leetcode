class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       List<List<Integer>> bucket=new ArrayList<>(n+1);
       for(int num:nums)
       map.put(num,map.getOrDefault(num,0)+1);
        for (int i = 0; i <= n; i++) 
        bucket.add(null);
        for(Integer key:map.keySet()){
        int freq=map.get(key);
        if(bucket.get(freq)==null)
        bucket.set(freq,new ArrayList<>());
        bucket.get(freq).add(key);
    }
        int[] ans = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && idx < k; i--) {
            if (bucket.get(i) != null)
                for (int num : bucket.get(i)) {
                    ans[idx++] = num;
                    if (idx == k) break;
                }
            
        }
        
        return ans;
    }
}