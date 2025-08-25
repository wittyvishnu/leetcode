class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int num=1;
        int left=0,right=n-1,top=0,bottom=n-1;
        while(left<=right && top <=bottom){
            for(int i=left;i<=right;i++){
                ans[top][i]=num;
                num++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans[i][right]=num;
                num++;
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                ans[bottom][i]=num;
                num++;
            }
            bottom--;
            }
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                ans[i][left]=num;
                num++;
            }
            left++;
            }
        }
        return ans;
    }
}