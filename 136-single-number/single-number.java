class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int n:nums) {
            m.put(n, m.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e:m.entrySet()) {
            if(e.getValue()==1) {
                return e.getKey();
            }
        }
        return -1;
    }
}