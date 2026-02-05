class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new ArrayDeque<>();
        int[] ans=new int[numCourses];
        int index=0;
        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<>());
         for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0){
                q.offer(i);
                ans[index++]=i;
                
            }
                
                while(!q.isEmpty()){
                    for(int neigh:adj.get(q.poll())){
                        indegree[neigh]--;
                        if(indegree[neigh]==0){
                            q.offer(neigh);
                            ans[index++]=neigh;
                        }
                    }
                }
        
        if(index!=numCourses)return new int[]{};
        return ans;
        
    }
    
}