class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<>());
         for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        int count=0;
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
            if(!visited[i]&&indegree[i]==0){
                q.offer(i);
                visited[i]=true;
                count++;
            }
                
                while(!q.isEmpty()){
                    for(int neigh:adj.get(q.poll())){
                        indegree[neigh]--;
                        if(!visited[neigh]&&indegree[neigh]==0){
                            q.offer(neigh);
                            visited[neigh]=true;
                            count++;
                        }
                    }
                }
        return count==numCourses;
    }
}