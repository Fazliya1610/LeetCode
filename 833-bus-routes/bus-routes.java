class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) {
            return 0;
        }
        int max = -1;
        boolean s = false;
        for(int[] route:routes) {
            for(int stop:route) {
                max = Math.max(max, stop);
                if(stop==source) {
                    s = true;
                }
            }
        }
        if(!s) {
            return -1;
        }
        if(max<target) {
            return -1;
        }
        int n = routes.length;
        int[] minBus = new int[max+1];
        Arrays.fill(minBus, n+1);
        minBus[source] = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            for(int[] r:routes) {
                int min = n+1;
                for(int stop:r) {
                    min = Math.min(min, minBus[stop]);
                }
                min++;
                for(int stop:r) {
                    if(minBus[stop]>min) {
                        minBus[stop] = min;
                        flag = true;
                    }
                }
            }
        }
        return (minBus[target]<n+1)?minBus[target]:-1;
    }
}