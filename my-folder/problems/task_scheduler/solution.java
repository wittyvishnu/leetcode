class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
       });
        for(char ch:tasks)
        map.put(ch,map.getOrDefault(ch,0)+1);
        pq.addAll(map.values());
        int time=0;
        while(!pq.isEmpty()){
            int cycle=n+1;
            List<Integer> temp=new ArrayList<>();
            while(cycle>0&&!pq.isEmpty()){
                int curr = pq.poll();
                if (curr > 1)
                    temp.add(curr - 1);
                time++;
                cycle--;
            }
            for(int freq:temp)
            pq.offer(freq);
            if(!pq.isEmpty())
            time+=cycle;
        }
        return time;
    }
}