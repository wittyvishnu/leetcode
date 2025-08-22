class Solution {
    public int trap(int[] height) {
        int[] left=maxToLeft(height);
        int[] right=maxToRight(height);
        int rainwater=0;
        for(int i=0;i<height.length;i++){
         int temp=Math.min(left[i],right[i])-height[i];
         if(temp>0)rainwater+=temp;
        }
        return rainwater;

        
    }
    public int[] maxToLeft(int[] height){
        int max=0;
        int[] left=new int[height.length];
        for(int i=0;i<height.length;i++){
            max=Math.max(height[i],max);
            left[i]=max;
        }
        return left;
    }
    public int[] maxToRight(int[] height){
        int max=0;
        int[] right=new int[height.length];
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(height[i],max);
            right[i]=max;
        }
        return right;
    }
}