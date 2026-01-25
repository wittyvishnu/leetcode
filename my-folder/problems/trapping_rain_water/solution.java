class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] suffixMax=new int[n];
        int temp=0;
        int res=0;
        for(int i=n-1;i>=0;i--){
            temp=(temp<height[i])?height[i]:temp;
            suffixMax[i]=temp;
        }
        temp=0;
        for(int i=0;i<n;i++){
            temp=(temp<height[i])?height[i]:temp;
            int water= Math.min(temp,suffixMax[i])-height[i];
            res+=(water>0)?water:0;
        }
        return res;

    }
}