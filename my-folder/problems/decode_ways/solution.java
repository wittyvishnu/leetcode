class Solution {
    int count=0;
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        if(s.equals(""))return 1;
        if(s.substring(0,1).equals("0"))return 0;
        dp[0]=1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            if(s.substring(i-1,i).compareTo("0")>0)
            dp[i]+=dp[i-1];
            int val = Integer.parseInt(s.substring(i - 2, i));
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    
    
}