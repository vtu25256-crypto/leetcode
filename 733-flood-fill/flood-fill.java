class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image; // no change needed
        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] img, int r, int c, int original, int color) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != original)
            return;

        img[r][c] = color;

        dfs(img, r + 1, c, original, color);
        dfs(img, r - 1, c, original, color);
        dfs(img, r, c + 1, original, color);
        dfs(img, r, c - 1, original, color);
    }
}