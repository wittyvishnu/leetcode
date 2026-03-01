class Solution {
    public String trimTrailingVowels(String s) {
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)!='a'&&s.charAt(i)!='e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u')
            break;
            i--;
        }
        if(i==-1)return "";
        return s.substring(0,i+1);
                
        
    }
}