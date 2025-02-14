class Solution {
    public int longestAwesome(String s) {
        if(s.length()==0) {
            return 0;
        }
        int f = 0, max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            f = f^(1<<(ch-'0'));
            if(map.containsKey(f)) {
                int curr = i - map.get(f);
                max = Math.max(max, curr);
            }
            else {
                map.put(f, i);
            }
            for(int d=0;d<=9;d++) {
                int odd = f^(1<<d);
                if(map.containsKey(odd)) {
                    int curr = i-map.get(odd);
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }
}