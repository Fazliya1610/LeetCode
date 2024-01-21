class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for(int money:nums) {
            int temp = curr;
            curr = Math.max(prev+money, curr);
            prev = temp;
        }
        return curr;    
    }
}