class Solution {
    int[] dx={-1,0,0,1};
    int[] dy={0,1,-1,0};
    int rows,cols;
    int[][] dp;
    int maxPath=0;
    public int longestIncreasingPath(int[][] matrix) {
        rows=matrix.length;
        cols=matrix[0].length;
        dp=new int[rows][cols];
        for(int[] row:dp)
        Arrays.fill(row,-1);
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        maxPath=Math.max(maxPath,longest(matrix,i,j));
        return maxPath;
        
    }
    
    public int longest(int[][] matrix,int m,int n){
        if (dp[m][n] != -1) return dp[m][n];
        int max=1;
        for(int k=0;k<4;k++){
            int x=m+dx[k];
            int y=n+dy[k];
            if(x >= 0 && x < rows && y >= 0 && y < cols && matrix[m][n] < matrix[x][y])
            max = Math.max(max, 1+longest(matrix, x, y));     
        }
        return dp[m][n] = max;
    }

}