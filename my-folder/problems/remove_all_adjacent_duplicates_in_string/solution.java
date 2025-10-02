class Solution {
    public String removeDuplicates(String s) {
        int len = s.length();
        char[] arr = new char[len];
        int j=0;
        
        for (char c : s.toCharArray()) {
            if(j==0||c!=arr[j-1]) arr[j++]=c;
            else j--;
            
        }
        return new String(arr,0,j);
        
        
    }
}
