class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=(s.charAt(0)!='0')?1:0;
        for(int i=2;i<n+1;i++){
            dp[i]=(s.charAt(i-1)!='0')?dp[i-1]:dp[i];
            int temp=Integer.parseInt(s.substring(i-2,i));
            if(temp>9 && temp<27)dp[i]+=dp[i-2];
        }
        return dp[n];
        
    }
    
}