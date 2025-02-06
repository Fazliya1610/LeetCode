class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] check = new int[n];
        for(int r=0;r<n;r++) {
            int j = 0;
            for(int i=r;i<n;i++) {
                check[j++] = nums[i];
            }
            for(int i=0;i<r;i++) {
                check[j++] = nums[i];
            }
            boolean isSorted = true;
            for(int i=0;i<n-1;i++) {
                if(check[i]>check[i+1]) {
                    isSorted = false;
                    break;
                }
            }
            if(isSorted) {
                return true;
            }
        }
        return false;
    }
}