class Solution {
    public boolean validPalindrome(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        int i=0,j=len-1;
        while(i<j){
            if(arr[i]!=arr[j]){
                return isPalindrome(arr,i+1,j)|| isPalindrome(arr,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(char[] arr,int start,int end){
        while(start<end){
            if(arr[start]!=arr[end])
            return false;
            start++;
            end--;
        }
        return true;
    }
}