class Solution {
    public long countCommas(long n) {
        long count = 0;
        // Start at the first comma (1,000)
        // Multiply by 1,000 to reach the next comma level
        for (long i = 1000; i <= n; i *= 1000) {
            // Every number from i to n has at least one comma at this level
            count += (n - i + 1);
        }
        return count;
    }
}
