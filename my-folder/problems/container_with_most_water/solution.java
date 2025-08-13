class Solution {
    public int maxArea(int[] height) {
    int i=0,j=height.length-1;
    int w,h,area,maxarea=0;
    while(i<j){
        w=j-i;
        h=Math.min(height[i],height[j]);
        area=w*h;
        maxarea=Math.max(maxarea,area);
        while(i<j && height[i]<=h)i++;
        while(i<j && height[j]<=h)j--;
    }
    return maxarea;
        
    }
}