class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] pacific=new int[m][n];
        int[][] atlantic=new int[m][n];
        Queue<int[]> q=new ArrayDeque<>();
       
        for(int j=0;j<n;j++){
            q.offer(new int[]{0,j});
            pacific[0][j]=1;
        }
        for(int i=0;i<m;i++){
            q.offer(new int[]{i,0});
            pacific[i][0]=1;
        }
        bfs(heights,q,pacific,m,n);
        
        for(int j=0;j<n;j++){
            q.offer(new int[]{m-1,j});
            atlantic[m-1][j]=1;
        }
        for(int i=0;i<m;i++){
            q.offer(new int[]{i,n-1});
            atlantic[i][n-1]=1;
        }
        bfs(heights,q,atlantic,m,n);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(pacific[i][j]== 1&& atlantic[i][j]==1)
        ans.add(Arrays.asList(i, j));
        return ans;


    }
    public void bfs(int[][] heights,Queue<int[]> q,int[][] arr,int m,int n){
        int[] dx={-1,0,0,1};
        int[] dy={0,-1,1,0};
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int d=0;d<4;d++){
                int x=node[0]+dx[d];
                int y=node[1]+dy[d];
                if(x>=0 && y>=0 && x<m && y<n && arr[x][y]==0&&heights[x][y]>=heights[node[0]][node[1]]){
                    q.offer(new int[]{x,y});
                    arr[x][y]=1;
                }
            }
        }
    }
}