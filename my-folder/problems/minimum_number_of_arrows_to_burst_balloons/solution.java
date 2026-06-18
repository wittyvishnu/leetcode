import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Safely sort by end coordinates using Integer.compare to prevent overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int ans = 1;
        int h = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, we need a new arrow
            if (points[i][0] > h) {
                ans++;
                h = points[i][1]; // Update arrow position to the end of the current balloon
            }
        }
        return ans;
    }
}
