class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words.length;j++) {
                if(i!=j&&matching(words[j], words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    private boolean matching(String s, String p) {
        int m = s.length(), n = p.length();
        for(int i=0;i<=m-n;i++) {
            int j = 0;
            while(j<n&&s.charAt(i+j)==p.charAt(j)) {
                j++;
            }
            if(j==n) {
                return true;
            }
        }
        return false;
    }
}