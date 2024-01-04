class Solution {
    public int minOperations(int[] nums) {
        var c = new HashMap<Integer, Integer>();
        for(int num:nums) {
            c.put(num, c.getOrDefault(num, 0)+1);
        }
            int count = 0;
            for(int counter:c.values()) {
                if(counter==1) {
                    return -1;
                }
                count+=Math.ceil((double)counter/3);
            }
            return count;
        }
} 
