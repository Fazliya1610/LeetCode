class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for (int digit = 1; digit <= 9; digit++) {
            int current = digit;
            int nextDigit = digit + 1;
            
            while (current <= high && nextDigit <= 9) {
                current = current * 10 + nextDigit;
                
                if (current >= low && current <= high) {
                    result.add(current);
                }
                
                nextDigit++;
            }
        }
        result.sort(null);
        return result;
    }
}