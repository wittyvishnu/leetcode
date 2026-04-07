class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int first_row=0,last_row=m-1;
        int first_col=0,last_col=n-1;
        List<Integer> ans=new ArrayList<>();
        while(first_row<=last_row || first_col<=last_col){
            if(first_row<=last_row){
            for(int i=first_col;i<=last_col;i++)
            ans.add(matrix[first_row][i]);
            first_row++;
            }

            if(first_col<=last_col){
            for(int i=first_row;i<=last_row;i++)
            ans.add(matrix[i][last_col]);
            last_col--;
            }


            if(first_row<=last_row){
            for(int i=last_col;i>=first_col;i--)
            ans.add(matrix[last_row][i]);
            last_row--;
            }

            if(first_col<=last_col){
            for(int i=last_row;i>=first_row;i--)
            ans.add(matrix[i][first_col]);
            first_col++;
            }


        }
        return ans;
    }
}