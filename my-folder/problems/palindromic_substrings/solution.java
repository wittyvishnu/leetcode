class Solution {
    public int countSubstrings(String s) {
        char[] ch=s.toCharArray();
        int n=ch.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            count+=count(ch,i,i);
            count+=count(ch,i,i+1);
        }
        count+=count(ch,n-1,n-1);
        return count;
    }
    public int count(char[] ch,int start,int end){
        int n=ch.length;
        int count=0;
        while(start>=0 && end<n && start<=end && ch[start]==ch[end]){
            start--;
            end++;
            count++;
        }
        return count;

    }
}