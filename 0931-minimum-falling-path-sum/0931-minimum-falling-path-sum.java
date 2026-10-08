class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // for (int j = m - 1; j >= 0; j--) {
        //   ans = Math.min(ans, top_Down(grid, n - 1, j,dp));
        //      // ans = Math.min(ans, rec(grid, n - 1, j));
        // }
        // return ans;

        return bottom_Up(grid, n, m, dp);
    }



    int bottom_Up(int[][] grid, int n, int m, int[][] dp) {
        int ans = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {

                if (i == n - 1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                // left
                int dj = j - 1;
                //    down
                int bj = j;
                // right
                int sj = j + 1;


                dp[i][j] = dp[i + 1][bj];

                if (dj >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][dj]);
                }

                if (sj < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][sj]);
                }

                dp[i][j] += grid[i][j];

            }
        }
        for(int x:dp[0]){
            ans=Math.min(ans,x);
        }
        return ans;
    }

    int top_Down(int[][] grid, int i, int j, int[][] dp) {

        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return dp[i][j] = grid[i][j];
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        return dp[i][j] = grid[i][j] + Math.min(
                top_Down(grid, i - 1, j, dp),
                Math.min(
                        top_Down(grid, i - 1, j + 1, dp),
                        top_Down(grid, i - 1, j - 1, dp)));
    }

    int rec(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return grid[i][j];
        }

        int ans = grid[i][j] + Math.min(
                rec(grid, i - 1, j),
                Math.min(
                        rec(grid, i - 1, j + 1),
                        rec(grid, i - 1, j - 1)));

        return ans;
    }
}