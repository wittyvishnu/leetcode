class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void solve(char[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rows = board.length;
        int cols = board[0].length;
        Queue<Pair> q=new ArrayDeque<>();
        for(int j=0;j<cols;j++){
            if(board[0][j]=='O'){
                q.offer(new Pair(0,j));
                board[0][j]='S';
            }
            if(board[rows-1][j]=='O'){
                q.offer(new Pair(rows-1,j));
                board[rows-1][j]='S';
            }
        }        
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                board[i][0]='S';
            }
            if(board[i][cols-1]=='O'){
                q.offer(new Pair(i,cols-1));
                board[i][cols-1]='S';
            }
        }
        while(!q.isEmpty()){
                 Pair temp = q.poll();
                for(int d = 0; d < 4; d++){
                    int nx = temp.first + dx[d];
                    int ny = temp.second + dy[d];
                    if(nx >= 0 && ny >= 0 && nx < rows && ny < cols && board[nx][ny] == 'O' ) {
                        board[nx][ny] ='S';
                        q.offer(new Pair(nx, ny));
                    }
                }
        }
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(board[i][j]=='O')board[i][j]='X';
        else if(board[i][j]=='S')board[i][j]='O';

        

    }
}