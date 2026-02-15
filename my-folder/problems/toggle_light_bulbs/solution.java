class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set=new HashSet<>();
        for(int bulb:bulbs)
            if(set.contains(bulb))
                set.remove(bulb);
            else
                set.add(bulb);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.addAll(set);
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty())
            ans.add(pq.poll());
        return ans;
    }
}