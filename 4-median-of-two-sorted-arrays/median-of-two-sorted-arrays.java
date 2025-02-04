class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(i<m&&j<n) {
            if(nums1[i]<nums2[j]) {
                nums[k] = nums1[i];
                k++;
                i++;
            }
            else if(nums1[i]>nums2[j]) {
                nums[k] = nums2[j];
                k++;
                j++;
            }
            else {
                nums[k] = nums1[i];
                k++;
                i++;
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }
        while(i<m) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        if((m+n)%2==1) {
            return (double)nums[(m+n)/2];
        }
        else {
            return (double)((double)nums[(m+n)/2]+(double)nums[(m+n)/2-1])/2.0;
        }
    }
}