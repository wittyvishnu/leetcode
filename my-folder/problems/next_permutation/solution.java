class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int j=n-2;j>=0;j--)
        if(nums[j]<nums[j+1]){
            index=j;
            break;
        }
        if(index==-1){
            reverse(nums,0,n-1);
            return;
        }
        int pivot=-1;
         for(int j=n-1;j>index;j--)
         if(nums[index]<nums[j]){
            pivot=j;
            break;
         }
         int temp=nums[index];
         nums[index]=nums[pivot];
         nums[pivot]=temp;
         reverse(nums,index+1,n-1);

    }
    public void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;
            r--;
        }
        
    }
}