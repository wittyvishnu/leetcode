class Solution {
    public int maxArea(int[] height) {
       int i=0,j=height.length-1;
       int w,h,area,maxarea=0;
       while(i<j){
            w=j-i;
            h=Math.min(height[j],height[i]);
            area=w*h;
            maxarea=Math.max(area,maxarea);
            if(height[i]<height[j])i++;
            else j--;           
       }
       
       return maxarea;
    }
}