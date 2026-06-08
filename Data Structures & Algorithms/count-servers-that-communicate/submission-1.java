class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int total = 0, disconnected = 0;
        int[] rowSums = new int[m], colSums = new int[n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                total += grid[i][j];
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1 && rowSums[i] == 1 && colSums[j] == 1)
                    ++disconnected;
        
        return total - disconnected;
    }
}