class Solution {
    public int uniquePaths(int m, int n) {
            if(n== 1&&m==1) return 1;
            int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }

        solve1(m, n, 0, 0, arr);
        return -1*arr[0][0];
    }

    static int solve1(int m, int n, int i, int j, int[][] arr) {

        if (i == m - 1 && j == n - 1) {
            arr[i][j] = 1;
            return arr[i][j];
        }

        if (i + 1 == m) {
            return 0;
        }

        if (j + 1 == n) {
            return 0;
        }

        if (arr[i][j + 1] == -1) {
            solve1(m, n, i, j + 1, arr);
        }

        int right = arr[i][j + 1];

        if (arr[i + 1][j] == -1) {
            solve1(m, n, i + 1, j, arr);
        }

        int left = arr[i + 1][j];

        arr[i][j] = left + right;
        return arr[i][j];
    }
   /* static int solve(int m, int n, int i, int j) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i == m) {
            return 0;
        }

        if (j == n) {
            return 0;
        }

        int right = solve(m, n, i, j + 1);
        int left = solve(m, n, i + 1, j);

        return left + right;
    }
    */
}