class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count==1) {
                nums[index++] = num;
            }
            else {
                nums[index++] = num;
                nums[index++] = num;
            }
        }
        sort(nums, index);
        return index;
    }

    private void sort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}