class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int n = piles.length;
        for (int pile : piles) 
            high = Math.max(high, pile);
        
        int ans = high;
        if (n == h) return ans;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hrs = hours(piles, mid, n);
            if (hrs <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public long hours(int[] piles, int speed, int n) {
        long h = 0;
        for (int i = 0; i < n; i++) {
            h += Math.ceil((double)piles[i]/speed);
        }
        return h;
    }
}
