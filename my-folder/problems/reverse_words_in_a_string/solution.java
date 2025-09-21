class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 1: Reverse the whole string
        reverse(arr, 0, n - 1);

        // Step 2: Reverse each word
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }

        // Step 3: Clean up spaces (remove extra spaces)
        return cleanSpaces(arr, n);
    }

    // Helper: Reverse characters from left to right
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Helper: Remove leading, trailing, and extra spaces
    private String cleanSpaces(char[] arr, int n) {
        int i = 0, j = 0;
        while (i < n) {
            // skip spaces
            while (i < n && arr[i] == ' ') i++;
            // copy word
            while (i < n && arr[i] != ' ') arr[j++] = arr[i++];
            // add single space if next word exists
            while (i < n && arr[i] == ' ') i++;
            if (i < n) arr[j++] = ' ';
        }
        return new String(arr, 0, j);
    }
}
