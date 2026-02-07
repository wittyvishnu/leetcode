class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] pacific=new int[m][n];
        int[][] atlantic=new int[m][n];
        Queue<Pair> q=new ArrayDeque<>();
        //pacific
        for(int j=0;j<n;j++){
            q.offer(new Pair(0,j));
            pacific[0][j]=1;
        }
        for(int i=0;i<m;i++){
            q.offer(new Pair(i,0));
            pacific[i][0]=1;
        }
        bfs(heights,q,pacific,m,n);
         //pacific
        for(int j=0;j<n;j++){
            q.offer(new Pair(m-1,j));
            atlantic[m-1][j]=1;
        }
        for(int i=0;i<m;i++){
            q.offer(new Pair(i,n-1));
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
    public void bfs(int[][] heights,Queue<Pair> q,int[][] arr,int m,int n){
        int[] dx={-1,0,0,1};
        int[] dy={0,-1,1,0};
        while(!q.isEmpty()){
            Pair temp=q.poll();
            for(int d=0;d<4;d++){
                int row=temp.r+dx[d];
                int col=temp.c+dy[d];
                if(row>=0&&row<m&&col>=0&&col<n&&arr[row][col] == 0&&heights[temp.r][temp.c]<=heights[row][col]){
                    q.offer(new Pair(row,col));
                    arr[row][col]=1;
                }

            }

        }
    }
}