class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0, l1 = nums1.length, l2 = nums2.length;
        long max = 0, s1 = 0, s2 = 0;
        while(i1<l1&&i2<l2) {
            if(nums1[i1]==nums2[i2]) {
                max+=Math.max(s1, s2)+nums1[i1];
                s1 = 0;
                s2 = 0;
                i1++;
                i2++;
            }
            else if(nums1[i1]<nums2[i2]) {
                s1+=nums1[i1];
                i1++;
            }
            else {
                s2+=nums2[i2];
                i2++;
            }
        }
        while(i1<l1) {
            s1+=nums1[i1];
            i1++;
        }
        while(i2<l2) {
            s2+=nums2[i2];
            i2++;
        }
        max+=Math.max(s1, s2);
        return (int) (max % (1e9 + 7));
    }
}