class Solution {
    public boolean isBipartite(int[][] graph) {
     int m=graph.length;
     int n=graph[0].length;
     int[] color=new int[m];//-1 for first color and 1 for second color 
     Queue<Integer> q=new ArrayDeque<>();
     for(int i=0;i<m;i++)
     if(color[i]==0){
        q.offer(i);
        color[i]=-1;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neigh:graph[node]){
                if(color[neigh]==0){
                    color[neigh]=-color[node];
                    q.offer(neigh);
                }else if(color[neigh]==color[node]) return false;
            }
        }

     }
     return true;

    }
}