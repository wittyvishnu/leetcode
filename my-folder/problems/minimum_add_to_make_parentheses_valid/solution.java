class Solution {
    public int minAddToMakeValid(String s) {
        int op=0,cl=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')op++;
            else{
                if(op>0)op--;
                else cl++;
            }
        }
        return op+cl;
        
    }
}