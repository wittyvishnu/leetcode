class Solution {
    List<List<String>> ans=new ArrayList<>();
    int len;
    public List<List<String>> partition(String s) {
        len=s.length();
        Backtrack(s,0,new ArrayList<>());
        return ans;

    }
    public void Backtrack(String s,int index,List<String> path){
        if(index==len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<len;i++){
            if(isPalindrome(s,index,i)){
            path.add(s.substring(index, i + 1)); 
            Backtrack(s,i+1,path);
            path.remove(path.size()-1);
            }
        }


    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}