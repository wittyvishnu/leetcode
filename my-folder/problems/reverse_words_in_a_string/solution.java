class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int index=0;
        while(arr[index]==' ')
        index++;
        for(int i=index;i<n;i++){
            if(arr[i]==' '){
                while(i+1<n&&arr[i+1]==' ')i++;
                ans.insert(0, " ");
                ans.insert(0,temp);
                temp.setLength(0);
            }else{
                temp.append(arr[i]);

            }

        }
        if(temp.length()>0){
            ans.insert(0, " ");
            ans.insert(0,temp);
        }

        if (ans.length() > 0) {
            return ans.substring(0, ans.length() - 1);
        } else {
            return ""; 
        }

        
    }
}
