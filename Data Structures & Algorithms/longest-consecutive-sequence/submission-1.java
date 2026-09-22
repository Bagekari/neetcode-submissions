class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int val : nums)
            set.add(val);
        
        int ans = 0;

        for (int val : nums) {
            if (set.contains(val - 1))
                continue;
            
            int num = val;
            int cnt = 1;

            while (set.contains(num + 1)) {
                ++num;
                ++cnt;
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}
