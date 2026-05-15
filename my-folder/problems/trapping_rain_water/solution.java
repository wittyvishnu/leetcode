class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] right=new int[n];
        int maxRight = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
        }
        int ans=0;
        int maxLeft=height[0];
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            int water = Math.min(maxLeft, right[i]) - height[i];
            ans += water; 
        }
      return ans;
    }
}