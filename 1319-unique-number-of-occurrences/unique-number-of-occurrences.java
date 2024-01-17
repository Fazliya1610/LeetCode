class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count= new HashMap<>();
        for(int num:arr) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        Set<Integer> unique = new HashSet<>(count.values());
        return unique.size()==count.size();
    }
}