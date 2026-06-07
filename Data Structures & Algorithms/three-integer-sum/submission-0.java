class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i + 2 < n; ++i) {
            for (List<Integer> list : twoSum(nums, i + 1, n - 1, -nums[i])) {
                List<Integer> triplet = new ArrayList<>(List.of(nums[i], list.get(0), list.get(1)));
                Collections.sort(triplet);
                ans.add(triplet);
            }
        }

        return new ArrayList<>(ans);
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = start; i <= end; ++i) {
            if (set.contains(target - nums[i])) {
                ans.add(new ArrayList<>(List.of(nums[i], target - nums[i])));
            }
            set.add(nums[i]);
        }

        return ans;
    }
}
