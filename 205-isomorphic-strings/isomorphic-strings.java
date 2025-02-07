class Solution {
    public boolean isIsomorphic(String s, String t) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int num = 1;
        for(char c:s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, num);
                num++;
                sb.append((char)num);
            }
            else {
                int label = map.get(c);
                sb.append((char)label);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        Map<Character, Integer> map1 = new HashMap<>();
        num = 1;
        for(char c:t.toCharArray()) {
            if(!map1.containsKey(c)) {
                map1.put(c, num);
                num++;
                sb1.append((char)num);
            }
            else {
                int label = map1.get(c);
                sb1.append((char)label);
            }
        }
        return sb.toString().equals(sb1.toString());
    }
}