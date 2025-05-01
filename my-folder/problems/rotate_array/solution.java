class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp=nums.clone();
        int n=nums.length;
        int index;
        k=k%n;
        for(int i=0;i<n;i++){
            index=(i+k)%n;
            nums[index]=temp[i];
        }
        
        
    }
}