class Solution {
    public int numIslands(char[][] grid) {
        int[] dx={-1,0,1,0};
        int[] dy={0,-1,0,1};
        int m=grid.length;
        int islands=0;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    islands++;
                    visited[i][j]=1;
                    Queue<int[]> q=new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] pair=q.poll();
                        int x=pair[0];
                        int y=pair[1];
                        for(int d=0;d<4;d++){
                            int nx=x+dx[d];
                            int ny=y+dy[d];
                            if(nx>=0&&nx<m &&ny>=0 && ny<n &&grid[nx][ny]=='1'&&visited[nx][ny]==0){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny]=1;
                            }
                        }
                        
                    }
                }
            }
        }
        return islands;
    }
}