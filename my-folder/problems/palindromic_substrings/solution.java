class Solution {
    public int countSubstrings(String s) {
        int count=0;
        char[] arr=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++){
            int left=i-1;
            int right=i+1;
            count++;
            while(left>=0&&right<n&&arr[left]==arr[right]){   //odd center
                count++;
                left--;
                right++;
            }
            if(i<=n-2&&arr[i]==arr[i+1]){
                count++;
                left=i-1;
                right=i+2;
                while(left>=0&&right<n&&arr[left]==arr[right]){   //Even center
                count++;
                left--;
                right++;
            }
            }

        }
        return count;

    }
}