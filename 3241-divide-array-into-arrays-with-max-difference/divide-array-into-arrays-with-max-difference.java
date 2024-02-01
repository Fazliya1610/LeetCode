class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 < nums.length && nums[i + 2] - nums[i] <= k) {
                result.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
            } else {
                return new int[0][0]; 
            }
        }
        int[][] resultArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> sublist = result.get(i);
            resultArray[i] = sublist.stream().mapToInt(Integer::intValue).toArray();
        }
        return resultArray;
    }
}