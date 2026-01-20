class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n)return -1;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int mid;
        int m_total=0;
        int k_total=0;
        while(min<max){
            mid=(min+max)/2;
            m_total=0;
            k_total=0;
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=mid){
                    k_total++;
                    if(k_total==k){
                        m_total++;
                        k_total=0;
                    }
                        
                }
                else
                k_total=0;
        

            }
            if(m_total<m)min=mid+1;
            else max=mid;
        }
        return min;
    }
}