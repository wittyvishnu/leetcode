class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = RowCheck(matrix, target, m, n);

        if (row == -1) return false; 

        return ColCheck(matrix, row, target, n);
    }

    public int RowCheck(int[][] matrix, int target, int m, int n) {
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                return mid; 
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; 
    }

    public boolean ColCheck(int[][] matrix, int row, int target, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) return true;
            else if (target > matrix[row][mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
