class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> q=new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j]=='1'){
            islands++;
            q.offer(new Pair(i,j));
            grid[i][j]='0';
            while(!q.isEmpty()){
            Pair temp = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = temp.first + dx[d];
                int ny = temp.second + dy[d];
                if(nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == '1' ) {
                    grid[nx][ny] ='0';
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        }
        return islands;
    }
}