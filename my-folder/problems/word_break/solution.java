class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        int maxLen=Integer.MIN_VALUE;
        for(String t:wordDict){
        set.add(t);
        maxLen=Math.max(maxLen,t.length());
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--)
            if(dp[j]&&set.contains(s.substring(j,i))){
            dp[i]=true;
            break;
            }
        }
        return dp[n];
    }
}