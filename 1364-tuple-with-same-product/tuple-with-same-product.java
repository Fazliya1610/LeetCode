class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> prod = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int p = nums[i]*nums[j];
                res+=8*prod.getOrDefault(p, 0);
                prod.put(p, prod.getOrDefault(p, 0)+1);
            }
        }
        return res;
    }
}