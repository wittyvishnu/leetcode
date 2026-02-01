class Solution {
    public int countMonobit(int n) {
        if(n==1) return 2;
        if(n==0)return 1;
        int i=0;
        while(Math.pow(2,i)<n&&Math.pow(2,i)!=n)
            i++;
        if(Math.pow(2,i)==n+1||Math.pow(2,i)==n)
            return i+1;
        return i;
    }
}