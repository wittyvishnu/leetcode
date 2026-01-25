class Solution {
    public int[] rotateElements(int[] nums, int k) {

        int n = nums.length;
        int[] index = new int[n];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                dq.addLast(nums[i]);
                index[idx++] = i;
            }
        }

        if (dq.isEmpty()) return nums;

        k = k % dq.size();


        for (int i = 0; i < k; i++) {
            dq.addLast(dq.removeFirst());
        }

        int j = 0;
        for (int val : dq) {
            nums[index[j++]] = val;
        }

        return nums;
    }
}
