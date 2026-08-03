class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        
        for(int i=1;i<=n/2;i++){
            if(canForm(s.substring(0,i),s))return true;
        }
        return false;
    }
    public boolean canForm(String pattern,String s){
        int n=s.length();
        int m=pattern.length();
        if(n%m!=0)return false;
        int idx=0;
        while(idx+m<=n&&s.substring(idx,idx+m).equals(pattern))idx=idx+m;
        return idx==n;
    }
}