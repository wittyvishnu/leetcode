class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         int n=words.length;
       HashMap<String,Integer> map=new HashMap<>();
       PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            if(map.get(a).equals(map.get(b)))
            return a.compareTo(b);
            return map.get(b)-map.get(a);
       });
        for(String word:words)
        map.put(word,map.getOrDefault(word,0)+1);
        for(String key:map.keySet())
        pq.offer(key);
        
        
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=k;i++)
        ans.add(pq.poll());
        
        return ans;
    }
}