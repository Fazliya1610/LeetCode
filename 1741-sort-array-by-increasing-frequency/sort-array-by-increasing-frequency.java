class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> m = new LinkedHashMap<>();
        for(int n : nums) {
            m.put(n, m.getOrDefault(n, 0)+1);
        }
        List<Integer> l = new ArrayList<>();
        for(int n:nums) {
            l.add(n);
        }
        Collections.sort(l, (a, b)->{
            int A = m.get(a);
            int B = m.get(b);
            if(A!=B) {
                return Integer.compare(A, B);
            }
            else {
                return Integer.compare(b, a);
            }
        });
        for(int i=0;i<nums.length;i++) {
            nums[i] = l.get(i);
        }
        return nums;
    }
}