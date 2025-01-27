class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int r = maze.length;
        int c = maze[0].length;
        boolean[][] vis = new boolean[r][c];
        q.add(entrance);
        vis[entrance[0]][entrance[1]] = true;
        int s = -1;
        int[][] dif = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            s++;
            int size = q.size();
            for(int i=1;i<=size;i++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                if(row==0||row==r-1||col==0||col==c-1) {
                    if(s>0) {
                        return s;
                    }
                }
                for(int j=0;j<4;j++) {
                    int ar = row+dif[j][0];
                    int ac = col+dif[j][1];
                    if(ar>=0&&ar<r&&ac>=0&&ac<c) {
                        if(maze[ar][ac]!='+'&&!vis[ar][ac]) {
                            q.add(new int[]{ar, ac});
                            vis[ar][ac] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}