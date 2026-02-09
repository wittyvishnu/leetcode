class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if(n==1)return triangle.get(0).get(0);
        int[][] dp=new int[n][n];
        int level=n-1;
        int idx=0;
        for(int num:triangle.get(n-1))
        dp[n-1][idx++]=num;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++)
            dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);

        }
        return dp[0][0];
        

    }
    
}