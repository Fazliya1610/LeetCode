class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result[0] = Math.abs(num); 
            } 
            else {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1; 
                break;
            }
        }
        return result;
    }
}