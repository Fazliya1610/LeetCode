class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFrequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1; 
    }
}