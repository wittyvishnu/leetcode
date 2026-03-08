class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<capacity.length;i++)
            if(capacity[i]>=itemSize&&(min==Integer.MAX_VALUE||capacity[i]<capacity[min]))
               min=i;
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}