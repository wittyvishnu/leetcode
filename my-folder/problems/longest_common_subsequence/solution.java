class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[] prev=new int[n+1];
        for(int i=1;i<=m;i++){
        int[] curr=new int[n+1];
        for(int j=0;j<=n;j++){
            if(j==0)curr[j]=0;
            else if(text1.charAt(i-1)==text2.charAt(j-1))curr[j]=1+prev[j-1];
            else curr[j]=Math.max(curr[j-1],prev[j]);
        }
        prev=curr;
        }
        return prev[n];

    }
}