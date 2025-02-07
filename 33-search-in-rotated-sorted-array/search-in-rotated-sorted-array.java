class Solution {
    public int search(int[] nums, int target) {
        int right = 0, left = nums.length-1;
        while(right<=left) {
            int mid = (right+left)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]>=nums[right]) {
                if(target>=nums[right]&&target<nums[mid]) {
                    left = mid-1;
                }
                else {
                    right = mid+1;
                }
            }
            else {
                if(target>nums[mid]&&target<=nums[left]) {
                    right = mid+1;
                }
                else {
                    left = mid-1;
                }
            }
        }
        return -1;
    }
}