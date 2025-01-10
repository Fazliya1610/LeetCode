class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] max = new int[26];
        int[] t = new int[26];
        for(String s:words2) {
            Arrays.fill(t, 0);
            for(char c:s.toCharArray()) {
                t[c-'a']++;
            }
            for(int i=0;i<26;i++) {
                max[i] = Math.max(max[i], t[i]);
            }
        }
        for(String s:words1) {
            Arrays.fill(t, 0);
            for(char c:s.toCharArray()) {
                t[c-'a']++;
            }
            boolean b = true;
            for(int i=0;i<26;i++) {
                if(max[i]>t[i]) {
                    b = false;
                    break;
                }
            }
            if(b) {
                res.add(s);
            }
        }
        return res;
    }

}