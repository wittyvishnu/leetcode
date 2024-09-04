class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int sum;
        int[] index=new int[2];
        while(i<j){
            sum=numbers[i]+numbers[j];
            if(sum==target){
                index[0]=i+1;
                index[1]=j+1;
                break;
            }
            else if(sum>target){
                j--;

            }
            else
            i++;

        }
        return index;
    }
}