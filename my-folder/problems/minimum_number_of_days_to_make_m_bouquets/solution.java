class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n)return -1;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int ans=max;
        while(min<=max){
            int mid=(min+max)/2;
            int bouquets=possible(bloomDay,mid,k);
            if(bouquets>=m){
                ans=mid;
                max=mid-1;

            }else min=mid+1;
            

        }
        return ans;
    }
    public int possible(int[] bloomDay,int n,int k){
        int bouquets=0;
        int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=n)
            count++;
            else{
                bouquets+=(count/k);
                count=0;
            }
        
        }
        bouquets += (count / k);
        return bouquets;
    }
}