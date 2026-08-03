class Solution {
    public boolean checkRecord(String s) {
        int absent=0;
        
        boolean consective=false;
        int late=0;
        for(char ch:s.toCharArray()){
            if(ch=='A')absent++;
            if(ch=='L')late++;
            else{
                consective=consective||(late>=3);
                late=0;
            }
        }
         consective=consective||(late>=3);
        if(consective||absent>=2)return false;
        return true;
        
    }
}