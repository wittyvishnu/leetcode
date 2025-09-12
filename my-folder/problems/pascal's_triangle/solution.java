class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;

        
    }
    public List<Integer> generateRow(int row){
        List<Integer> rowAns=new ArrayList<>();
        long ans=1;
        rowAns.add((int) ans);
        for(int i=1;i<row;i++){
            ans=(ans*(row-i))/i;
            rowAns.add((int)ans);
        }
        return rowAns;
    }
}