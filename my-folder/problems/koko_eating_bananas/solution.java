class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=piles[0];
        for(int i=1;i<piles.length;i++)
        high=Math.max(high,piles[i]);
        int low=1;
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            long hrs=hours(piles,mid);
            if (hrs <= h) { // ✅ valid
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // increase speed
            }
        }
        return ans;

    }
    public long hours(int[] piles,int speed){
        long hours=0;
        for(int pile:piles)
        hours += (pile + speed - 1) / speed;
        return hours;
        
    }
}