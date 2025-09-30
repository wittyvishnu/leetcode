class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] map = new int[26];
        for (char c : s1.toCharArray()) map[c - 'a']++;

        int left = 0, right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            if (map[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            map[s2.charAt(right) - 'a']--;
            right++;

            if (count == 0) return true;
            if (right - left == s1.length()) {
                if (map[s2.charAt(left) - 'a'] >= 0)
                    count++;
                map[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}
