class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++)
            map.put(nums[i], i);

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            Integer j = map.get(k);
            if (j != null && i != j) {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;
    }
}
