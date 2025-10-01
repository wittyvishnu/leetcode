class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // frequency of each char
        int maxCount = 0;          // max freq of any char in current window
        int left = 0, right = 0, ans = 0;

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
