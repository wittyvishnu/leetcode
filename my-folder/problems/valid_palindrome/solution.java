class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str=new StringBuilder();
        for(char c:s.toCharArray())
         if(Character.isLetterOrDigit(c))
        str.append(Character.toLowerCase(c));
        int j=str.length()-1;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(j)) return false;
            j--;
        }
        return true;
            

    }
}