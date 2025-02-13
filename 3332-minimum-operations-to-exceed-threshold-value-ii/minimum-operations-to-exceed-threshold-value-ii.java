class Solution {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num:nums) {
            pq.add((long)num);
        }
        long x, y;
        while(pq.peek()<k) {
            x = pq.poll();
            if(!pq.isEmpty()) {
                y = pq.poll();
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