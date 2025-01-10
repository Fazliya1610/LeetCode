class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String s1, String s2) {
        if(s1.length()>s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
            return false;
        }
        int len = s1.length();
        int len1 = s2.length();
        return s1.equals(s2.substring(0, len))&&s1.equals(s2.substring(len1-len, len1));
    }
}