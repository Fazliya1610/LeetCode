class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String first = s.substring(0,n/2);
        String second = s.substring(n/2);
        return vowels(first)==vowels(second);
    }
    public static int vowels(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(index(s.charAt(i))!=-1) {
                count++;
            }
        }
        return count;
    }
    public static int index(char c) {
        return "AEIOUaeiou".indexOf(c);
    }
}