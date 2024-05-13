class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] largest = new int[m];

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                continue;
            for (int j = 0; j < n; j++) {
                grid[i][j] = (grid[i][j] + 1) % 2;
            }
            largest[i] |= 1 << (n - 1);
        }
        for (int j = 0; j < n; j++) {
            int ones = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) ones++;
                largest[i] |= (grid[i][j] << (n - j - 1));
            }
            if (ones > m/2) continue;

            for (int i = 0; i < m; i++) {
                largest[i] ^= (1 << (n - j - 1));
            }
        }

        int sum = 0;
        for (int num : largest) {
            sum += num;
        }
        return sum;
    }
}
