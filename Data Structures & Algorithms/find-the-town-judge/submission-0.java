class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[1001];
        int[] outdeg = new int[1001];

        for (int[] t : trust) {
            ++outdeg[t[0]];
            ++indeg[t[1]];
        }
        
        int label = -1;

        for (int i = 1; i <= n; ++i)
            if (indeg[i] == n - 1 && outdeg[i] == 0) {
                if (label == -1)
                    label = i;
                else
                    return -1;
            }

        return label;
    }
}