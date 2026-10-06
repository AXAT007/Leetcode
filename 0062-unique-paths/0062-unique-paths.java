class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return top_Down(m, n, 0, 0, dp);

        // return rec(m, n, 0, 0, null);

        return bottom_Up(m - 1, n - 1, dp);
        // return no_Space(m, n);

    }

    int rec(int n, int m, int i, int j, int[][] dp) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = rec(n, m, i + 1, j, dp) +
                rec(n, m, i, j + 1, dp);
    }

    int top_Down(int n, int m, int i, int j, int[][] dp) {
        if (i == n - 1 && j == m - 1)
            return 1;
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = top_Down(n, m, i + 1, j, dp) +
                top_Down(n, m, i, j + 1, dp);
    }

    int bottom_Up(int m, int n, int[][] dp) {
        for(int i = 0;i<=m;i++){
            dp[i][n] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[m][j] = 1;
            
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    int no_Space(int m, int n) {
        return 0;
    }
}