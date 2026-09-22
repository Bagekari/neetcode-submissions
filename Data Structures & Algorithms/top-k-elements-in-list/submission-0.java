class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : nums)
            map.merge(val, 1, Integer::sum);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (e1, e2) -> Integer.compare(map.get(e1), map.get(e2))
        );

        for (int key : map.keySet()) {
            heap.offer(key);

            if (heap.size() > k)
                heap.poll();
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; ++i)
            ans[i] = heap.poll();
        
        return ans;
    }
}
