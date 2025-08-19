class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hash=new HashSet<String>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!hash.add(board[i][j]+"in row"+i) ||
                    !hash.add(board[i][j]+"in column"+j) ||
                    !hash.add(board[i][j]+"in sub box"+i/3+"-"+j/3)) return false;
                }
            }
        }
        return true;
    }
}