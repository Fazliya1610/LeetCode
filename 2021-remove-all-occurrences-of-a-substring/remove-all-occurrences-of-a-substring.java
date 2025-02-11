class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int partLen = part.length();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= partLen && sb.substring(sb.length() - partLen).equals(part)) {
                sb.delete(sb.length() - partLen, sb.length());
            }
        }
        return sb.toString();
    }
}