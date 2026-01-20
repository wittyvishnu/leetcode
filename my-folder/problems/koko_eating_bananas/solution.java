class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        if(max<piles[i])max=piles[i];
        int min=1;
        if(h==piles.length) return max;
        int start=min,end=max;
        int mid;
        int hours;
        while(start<end){
            mid=(start+end)/2;
            hours=0;
            for(int i=0;i<piles.length;i++)
            hours+=(piles[i]+mid-1)/mid;
            if(hours>h)start=mid+1;
            else end=mid;
        }
        return start;
    }
}