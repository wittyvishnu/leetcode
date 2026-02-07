class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new ArrayDeque<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int minutes=0;
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j]==2)
        q.offer(new Pair(i,j));


        int[] dx={-1,0,0,1};
        int[] dy={0,-1,1,0};
        while(!q.isEmpty()){
            boolean rotted = false;
            int size=q.size();
            while(size>0){
                Pair temp=q.poll();
                for(int d=0;d<4;d++){
                    int row=temp.r+dx[d];
                    int col=temp.c+dy[d];
                    if(row>=0&&row<rows&&col>=0&&col<cols&&grid[row][col] == 1){
                        q.offer(new Pair(row,col));
                        grid[row][col]=2;
                        rotted=true;
                    }

                }
            size--;
            }
            if(rotted)minutes++;
        }
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j]==1)
        return -1;
        return minutes;
    }
}