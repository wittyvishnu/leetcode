class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n-1] != 9) {
            digits[n-1]++;
            return digits;
        } else {
            int i = n - 1;
            while (i >= 0 && digits[i] == 9) {
                digits[i] = 0; 
                i--;
            }
            if (i == -1) {
                int[] result = new int[n + 1];
                result[0] = 1;   
                return result;
            } else {
                digits[i]++;   
            }
        }
        return digits;
    }
}
