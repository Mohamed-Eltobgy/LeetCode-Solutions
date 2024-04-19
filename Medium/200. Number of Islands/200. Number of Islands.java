class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    void dfs(char[][] grid, int i, int j, boolean visited[][]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) // Out of bounds.
            return;

        if (visited[i][j] || grid[i][j] == '0')  // Already visited or not a land.
            return;

        visited[i][j] = true;
        // Check all 4 directions.
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }
}
