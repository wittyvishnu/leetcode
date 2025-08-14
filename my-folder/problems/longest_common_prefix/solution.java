class Solution {
    public String longestCommonPrefix(String[] strs) {
       StringBuilder ans =new StringBuilder();
       char character;
       for(int j=0;j<strs[0].length();j++){
        character=strs[0].charAt(j);
       for(int i=1;i<strs.length;i++)
        if(strs[i].length()<=j || character!=strs[i].charAt(j))
        return ans.toString();
       ans.append(character);
       
    }
    return ans.toString();
    }
}