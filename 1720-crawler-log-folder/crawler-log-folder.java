class Solution {
    public int minOperations(String[] logs) {
        int d = 0;
        for(String l:logs) {
            if(l.equals("../")) {
                if(d>0) {
                    d--;
                }
            }
            else if(!l.equals("./")) {
                d++;
            }
        }
        return d;
    }
}