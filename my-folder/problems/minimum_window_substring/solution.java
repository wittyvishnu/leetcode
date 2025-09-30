class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)return "";
        int[] hash=new int[256];
        int l=0,r=0,count=0,minlength=Integer.MAX_VALUE,startIndex = -1;
        int m=s.length(),n=t.length();
        for(char c:t.toCharArray())
        hash[c]++;
       while(r<m){
        if(hash[s.charAt(r)]>0)count++;
        hash[s.charAt(r)]--;
        r++;
        while(count==n){
            if(r-l<minlength){
                minlength=r-l;
                startIndex=l;
            }
            hash[s.charAt(l)]++;
            if(hash[s.charAt(l)]>0)count--;
            l++;

        }
       }
       return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minlength);
    }
}