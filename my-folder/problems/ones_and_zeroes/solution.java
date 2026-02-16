class Solution {
    int[][][] dp;
    int len;
    public int findMaxForm(String[] strs, int m, int n) {
        len=strs.length;
        dp=new int[m+1][n+1][len];
        for (int[][] matrix : dp) {      // Iterate over each 2D matrix
            for (int[] row : matrix) {   // Iterate over each 1D row
                Arrays.fill(row, -1);    // Finally, fill the 1D array with -1
            }
        }
        return findMax(strs,m,n,0);
        
    }
    public int findMax(String[] strs, int m, int n,int idx){
        if(idx==len)return 0;
        if(dp[m][n][idx]!=-1)return dp[m][n][idx];
        int countZeros=0;
        for(char ch:strs[idx].toCharArray())
        if(ch=='0')countZeros++;
        int countOnes=strs[idx].length()-countZeros;
        if(m-countZeros>=0&&n-countOnes>=0)
        return dp[m][n][idx]=Math.max(1+findMax(strs,m-countZeros,n-countOnes,idx+1),findMax(strs,m,n,idx+1));
        return dp[m][n][idx]=findMax(strs,m,n,idx+1);

    }
}