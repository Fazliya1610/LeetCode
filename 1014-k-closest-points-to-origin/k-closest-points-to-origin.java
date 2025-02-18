class Solution {

    private int euclidean(int[] point) {
        return point[0]*point[0]+point[1]*point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> euclidean(a)-euclidean(b));
        for(int[] p:points) {
            heap.offer(p);
        }
        int index = 0;
        while(index<k) {
            int[] p = heap.poll();
            res[index][0] = p[0];
            res[index][1] = p[1];
            index++;
        }
        return res;
    }
}