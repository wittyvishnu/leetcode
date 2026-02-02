class Solution {
    public String frequencySort(String s) {
       HashMap<Character,Integer> map=new HashMap<>();
       PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->{
            return map.get(b)-map.get(a);
       });
        for(char ch:s.toCharArray())
        map.put(ch,map.getOrDefault(ch,0)+1);
        pq.addAll(map.keySet());;
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            sb.append(String.valueOf(ch).repeat(map.get(ch)));
        }
        return sb.toString();
    }
}