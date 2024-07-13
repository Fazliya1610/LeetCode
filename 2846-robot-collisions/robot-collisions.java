class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] r = new Robot[n];
        for(int i=0;i<n;i++) {
            r[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(r, Comparator.comparingInt(rob -> rob.p));
        Stack<Robot> s = new Stack<>();
        for(Robot rob:r) {
            if(rob.d=='R') {
                s.push(rob);
            }
            else {
                while(!s.isEmpty()&&s.peek().d=='R'&&s.peek().h<rob.h) {
                    rob.h--;
                    s.pop();
                }
                if(!s.isEmpty()&&s.peek().d=='R'&&s.peek().h==rob.h) {
                    s.pop();
                }
                else if(!s.isEmpty()&&s.peek().d=='R') {
                    Robot t = s.pop();
                    s.push(new Robot(t.p, t.h-1, t.d, t.i));
                }
                else {
                    s.push(rob);
                }
            }
        }
        List<Robot> sur = new ArrayList<>(s);
        sur.sort(Comparator.comparingInt(rob -> rob.i));
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<sur.size();i++) {
            res.add(sur.get(i).h);
        }
        return res;
    }

    static class Robot {
        int p, h, i;
        char d;
        Robot(int p, int h, char d, int i) {
            this.p = p;
            this.h = h;
            this.d = d;
            this.i = i;
        }
    }
}