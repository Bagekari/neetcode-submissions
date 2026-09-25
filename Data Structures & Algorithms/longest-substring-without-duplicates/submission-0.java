class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] line = s.toCharArray();
        int n = line.length;
        int ans = 0;

        for (int start = 0, end = 0; end < n; ++end) {
            map.merge(line[end], 1, Integer::sum);

            while (map.size() < end - start + 1) {
                map.merge(line[start], -1, Integer::sum);

                if (map.get(line[start]) == 0)
                    map.remove(line[start]);
                
                ++start;
            }

            if (map.size() == end - start + 1)
                ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}
