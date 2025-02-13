class Solution {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num:nums) {
            pq.add((long)num);
        }
        while(pq.peek()<k) {
            long x = pq.poll();
            if(!pq.isEmpty()) {
                long y = pq.poll();
                pq.add((long)x*2+y);
                operations++;
            }
            else {
                break;
            }
        }
        return operations;
    }
}