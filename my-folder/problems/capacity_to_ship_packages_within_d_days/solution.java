class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int t_days=0;
        int min= Integer.MIN_VALUE;
        int max=0;
        for(int i=0;i<weights.length;i++){
        max+=weights[i];
        min=(min<weights[i])?weights[i]:min;
        }
        int n=weights.length;
        int w=0;
        int mid;
        while(min<max){
            mid=(min+max)/2;
            t_days=0;
            w=0;
            for(int i=0;i<n;i++){
                if(w+weights[i]<=mid)
                w+=weights[i];
                else{
                    w=0;
                    t_days++;
                    w+=weights[i];
                }
            }
            t_days++;
            if(t_days>days) min=mid+1;
            else max=mid;

        }
        return min;
    }
}