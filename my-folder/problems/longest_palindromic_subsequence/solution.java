class Solution {
   public int longestPalindromeSubseq(String s) {
    char[] arr = s.toCharArray();
    int low = 0;
    int high = arr.length - 1;
    while (low < high) {
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        low++;
        high--;
    }
    String rev = new String(arr);
    return lcs(s, rev);
}


    public int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] l = new int[m + 1][n + 1];

        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }

        // Length of LCS
        int len = l[m][n];
        // char[] ans = new char[len];

        // Traceback to build LCS string
        // int i = m, j = n;
        // while (i > 0 && j > 0) {
        //     if (x.charAt(i - 1) == y.charAt(j - 1)) {
        //         ans[len - 1] = x.charAt(i - 1);
        //         i--;
        //         j--;
        //         len--;
        //     } else if (l[i - 1][j] > l[i][j - 1]) {
        //         i--;
        //     } else {
        //         j--;
        //     }
        // }
        return len;
    }
}
