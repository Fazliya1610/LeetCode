class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charCountS = new HashMap<>();
        Map<Character, Integer> charCountT = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int requiredChars = charCountT.size();
        int formedChars = 0; 
        while (right < s.length()) {
            char c = s.charAt(right);
            charCountS.put(c, charCountS.getOrDefault(c, 0) + 1);
            if (charCountT.containsKey(c) && charCountS.get(c).intValue() == charCountT.get(c).intValue()) {
                formedChars++;
            }
            while (left <= right && formedChars == requiredChars) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                charCountS.put(leftChar, charCountS.get(leftChar) - 1);
                if (charCountT.containsKey(leftChar) && charCountS.get(leftChar).intValue() < charCountT.get(leftChar).intValue()) {
                    formedChars--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
