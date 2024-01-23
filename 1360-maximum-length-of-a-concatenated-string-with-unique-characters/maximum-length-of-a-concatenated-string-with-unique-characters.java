class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }
    private int backtrack(List<String> arr, int index, String curr) {
        if(!unique(curr)) {
            return 0;
        }
        int len = curr.length();
        for(int i=index;i<arr.size();i++) {
            len = Math.max(len, backtrack(arr, i+1, curr+arr.get(i)));
        }
        return len;
    }
    private boolean unique(String str) {
        Set<Character> s = new HashSet<>();
        for(char c: str.toCharArray()) {
            if(!s.add(c)) {
                return false;
            }
        }
        return true;
    }
}