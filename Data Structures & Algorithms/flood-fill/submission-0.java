class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        
        solve(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void solve(int[][] image, int i, int j, int color, int pixel) {
        if (i < 0 || j < 0 || i == image.length || j == image[0].length || image[i][j] != pixel)
            return;
        
        image[i][j] = color;

        solve(image, i - 1, j, color, pixel);
        solve(image, i, j - 1, color, pixel);
        solve(image, i + 1, j, color, pixel);
        solve(image, i, j + 1, color, pixel);
    }
}