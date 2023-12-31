class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = 0;
        boolean found = false;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length();j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    int l = s.substring(i+1,j).length();
                    if(l > max) {
                        max = l;
                    }
                    found = true;
                }
            }
        }
        if(found) {
            return max;
        }
        else {
            return -1;
        }
    }
}