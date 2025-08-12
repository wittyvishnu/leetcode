class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total_len = nums1.length + nums2.length;
        int i = 0, j = 0, k = 0;
        int[] merge = new int[total_len / 2 + 1]; // store only up to middle
        
        // Merge until we fill half+1 elements
        while (i < nums1.length && j < nums2.length && k < merge.length) {
            if (nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }
        
        while (i < nums1.length && k < merge.length) {
            merge[k++] = nums1[i++];
        }
        
        while (j < nums2.length && k < merge.length) {
            merge[k++] = nums2[j++];
        }
        
        
        if (total_len % 2 == 0) {
            return (merge[merge.length - 1] + merge[merge.length - 2]) / 2.0; 
        } else {
            return merge[merge.length - 1];
        }
    }
}
