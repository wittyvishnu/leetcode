class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxRight=new int[n];
        int max=n-1;
        for(int i=n-1;i>=0;i--){
            maxRight[i]=max;
            max=height[i]>height[max]?i:max;
        }
        int water=0;
        int maxLeft=0;
        for(int i=0;i<n;i++){
            int temp=Math.min(height[maxLeft],height[maxRight[i]])-height[i];
            if(temp>0)water+=temp;
            maxLeft=height[i]>height[maxLeft]?i:maxLeft;
        }
        return water;
        
    }
}