class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowAns=new ArrayList<>();
        long ans=1;
        rowAns.add((int)ans);
        for(int i=1;i<=rowIndex;i++){
            ans=(ans*(rowIndex+1-i))/i;
            rowAns.add((int) ans);
        }
        return rowAns;

        
    }

}