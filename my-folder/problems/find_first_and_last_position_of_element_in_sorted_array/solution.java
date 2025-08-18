class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;

        // Binary search for one occurrence
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        // If not found
        if (index == -1) return new int[]{-1, -1};

        // Expand left and right
        int i = index, j = index;
        while (i > 0 && nums[i - 1] == target) i--;
        while (j < nums.length - 1 && nums[j + 1] == target) j++;

        return new int[]{i, j};
    }
}
