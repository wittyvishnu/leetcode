class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        for(int num:nums){
            int freq=map.getOrDefault(num,0);
            maxLen=Math.max(freq+1,maxLen);
            map.put(num,freq+1);
        }
        ArrayList<ArrayList<Integer>> bucket=new ArrayList<>();
        for(int i=0;i<=maxLen;i++)
        bucket.add(new ArrayList<>());
        for(int key:map.keySet())
        bucket.get(map.get(key)).add(key);
        int idx=k-1;

        while(idx>=0){
            for(int i=maxLen;i>0&&idx>=0;i--){
                
                for(int j=0;j<bucket.get(i).size()&&idx>=0;j++)
                ans[idx--]=bucket.get(i).get(j);
            }
        }

        return ans;

        
    }
}