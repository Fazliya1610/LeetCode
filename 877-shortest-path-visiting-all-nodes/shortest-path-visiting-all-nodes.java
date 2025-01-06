class Solution {
    public int shortestPathLength(int[][] g) {
        int[][] dp = new int[g.length][1<<g.length];
        Queue<State> q = new LinkedList<>();
        for(int i=0;i<g.length;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i] = 0;
            q.offer(new State(1<<i, i));
        }
        while(!q.isEmpty()) {
            State state = q.poll();
            for(int next:g[state.s]) {
                int nm = state.m|1<<next;
                if(dp[next][nm]>dp[state.s][state.m]+1) {
                    dp[next][nm] = dp[state.s][state.m]+1;
                    q.offer(new State(nm, next));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<g.length;i++) {
            res = Math.min(res, dp[i][(1<<g.length)-1]);
        }
        return res;
    }
    
    static class State {
        public int m, s;
        public State(int m, int s) {
            this.m = m;
            this.s = s;
        }
    }
}