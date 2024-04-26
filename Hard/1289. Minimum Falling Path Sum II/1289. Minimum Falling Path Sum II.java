class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return grid[0][0];
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (dp[i-1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i-1][j];
                } else if (dp[i-1][j] < min2) {
                    min2 = dp[i-1][j];
                }
            }
            for (int j = 0; j < n; j++) {
                if (dp[i-1][j] == min1)
                    dp[i][j] = min2 + grid[i][j];
                else
                    dp[i][j] = min1 + grid[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n-1][i] < min)
                min = dp[n-1][i];
        }
        
        return min;
    }
}
