class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=1;i<sb.length();i++) {
            if(sb.charAt(i)>='0'&&sb.charAt(i)<='9') {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i-=2;
            }
        }
        return sb.toString();
    }
}