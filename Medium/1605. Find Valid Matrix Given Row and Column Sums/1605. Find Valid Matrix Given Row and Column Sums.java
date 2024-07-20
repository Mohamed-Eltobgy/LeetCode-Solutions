class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        int counter1 = 0, counter2 = 0;
        while (counter1 < m && counter2 < n) {
            if (rowSum[counter1] < colSum[counter2]) {
                ans[counter1][counter2] = rowSum[counter1];
                colSum[counter2] -= rowSum[counter1];
                counter1++;
            } else if (rowSum[counter1] > colSum[counter2]) {
                ans[counter1][counter2] = colSum[counter2];
                rowSum[counter1] -= colSum[counter2];
                counter2++;
            } else {
                ans[counter1][counter2] = rowSum[counter1];
                counter1++;
                counter2++;
            }
        }
        return ans;
    }
}
