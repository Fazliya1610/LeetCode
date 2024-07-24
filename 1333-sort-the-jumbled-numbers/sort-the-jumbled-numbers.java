class Solution {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> mappedNums = new ArrayList<>();
        for (int num : nums) {
            mappedNums.add(new int[]{num, getMappedValue(num, mapping)});
        }
        Collections.sort(mappedNums, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return 0;
            }
        });
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < mappedNums.size(); i++) {
            sortedNums[i] = mappedNums.get(i)[0];
        }
        return sortedNums;
    }

    private static int getMappedValue(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        StringBuilder mappedValue = new StringBuilder();
        while (num > 0) {
            int digit = num % 10;
            mappedValue.insert(0, mapping[digit]);
            num /= 10;
        }
        while (mappedValue.length() > 0 && mappedValue.charAt(0) == '0') {
            mappedValue.deleteCharAt(0);
        }
        if (mappedValue.length() == 0) {
            return 0;
        }
        return Integer.parseInt(mappedValue.toString());
    }
}