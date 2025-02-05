class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = s1.length();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                swap(c1, i, j);
                if(Arrays.equals(c1, c2)) {
                    return true;
                }
                swap(c1, i, j);
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                swap(c2, i, j);
                if(Arrays.equals(c1, c2)) {
                    return true;
                }
                swap(c2, i, j);
            }
        }
        return false;
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}