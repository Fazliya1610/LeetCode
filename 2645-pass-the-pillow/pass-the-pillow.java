class Solution {
    public int passThePillow(int n, int time) {
        int pos = 1;
        int dir = 1;
        while(time>0) {
            pos+=dir;
            if(pos==n||pos==1) {
                dir*=-1;
            }
            time--;
        }
        return pos;
    }
}