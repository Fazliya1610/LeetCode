class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0&&nums[i]>=nums[i+1]) {
            i--;
        }
        if(i<0) {
            Arrays.sort(nums);
            return;
        }
        int j = n-1;
        while(j>=0&&nums[j]<=nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i+1, n-1);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void reverse(int[] arr, int s, int e) {
        while(s<e) {
            swap(arr, s, e);
            s++;
            e--;
        }
    }
}