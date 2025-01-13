class Solution {
    public int minimumLength(String s) {
        if(s.length()<=2) {
            return s.length();
        }
        int[] a = new int[26];
        for(char c:s.toCharArray()) {
            a[c-'a']++;
        }
        int count = 0;
        for(int i=0;i<26;i++) {
            if(a[i]%2==0&&a[i]>0) {
                count+=2;
            }
            else if(a[i]%2==1&&a[i]>0) {
                count+=1;
            }
        }
        return count;
    }
}