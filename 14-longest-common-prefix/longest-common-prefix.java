class Solution {
    public String longestCommonPrefix(String[] strs) {
        String com = strs[0];
        for(int i=1;i<strs.length;i++) {
            com = common(com, strs[i]);
        }
        return com;
    }
    public String common(String s1, String s2) {
        String c = "";
        for(int i=0;i<s1.length()&&i<s2.length();i++) {
            if(s1.charAt(i)==s2.charAt(i)) {
                c+=s1.charAt(i);
            }
            else {
                break;
            }
        }
        return c;
    }
}