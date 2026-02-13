class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[] prev=new int[n+1];
        for(int i=0;i<n+1;i++)
        prev[i]=i;
        for(int i=1;i<=m;i++){
        int[] curr=new int[n+1];
        curr[0]=i;
        for(int j=1;j<=n;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1))curr[j]=prev[j-1];
            else curr[j]=1+Math.min(prev[j-1],Math.min(curr[j-1],prev[j]));
        }
        prev=curr;
        }
        return prev[n];
    }
}