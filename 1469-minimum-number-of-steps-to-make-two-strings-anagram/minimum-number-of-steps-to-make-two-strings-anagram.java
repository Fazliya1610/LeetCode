class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sf = new HashMap<>();
        Map<Character, Integer> tf = new HashMap<>();
        for(char ch:s.toCharArray()) {
            sf.put(ch, sf.getOrDefault(ch, 0)+1);
        }
        for(char ch:t.toCharArray()) {
            tf.put(ch, tf.getOrDefault(ch, 0)+1);
        }
        int steps = 0;
        for(char ch:sf.keySet()) {
            int d = sf.get(ch)-tf.getOrDefault(ch,0);
            steps+=Math.max(0,d);
        }
        return steps;
    }
}