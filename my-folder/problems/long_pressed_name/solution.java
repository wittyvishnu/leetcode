class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n1=name.length();
        int n2=typed.length();
        int idx=0;
        for(int i=0;i<n1;i++){
            if(idx>=n2||name.charAt(i)!=typed.charAt(idx))return false;
            else{
                if(i<n1-1&&name.charAt(i)==name.charAt(i+1))idx++;
                else
                    while(idx<n2&&name.charAt(i)==typed.charAt(idx))idx++;
                
            }
        }
        return idx==n2;
    }
}