class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) {
            return false;
        }
        Map<Character, Integer> f1 = new HashMap<>();
        Map<Character, Integer> f2 = new HashMap<>();
        for(char c: word1.toCharArray()) {
            f1.put(c, f1.getOrDefault(c, 0)+1);
        }
        for(char c: word2.toCharArray()) {
            f2.put(c, f2.getOrDefault(c, 0)+1);
        }
        if(!f1.keySet().equals(f2.keySet())) {
            return false;
        }
        return f1.values().stream().sorted().collect(Collectors.toList()).equals(f2.values().stream().sorted().collect(Collectors.toList()));
    }
}