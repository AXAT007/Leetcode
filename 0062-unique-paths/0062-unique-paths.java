class Solution {
    public int uniquePaths(int m, int n) {
        return no_Space(m, n);

       
        // int[][] dp = new int[m][n];

        // for (int i = 0; i < m; i++) {
            // Arrays.fill(dp[i], -1);
        // }
// return top_Down(m, n, 0, 0, dp);

        // return rec2(m-1, n-1);

        // return top_Down2(m-1, n-1, dp);

        // return rec(m, n, 0, 0, null);

        // return bottom_Up(m - 1, n - 1, dp);
       
    }

        int rec2(int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0 )
            return 0;
        return rec2(i-1, j) +
                rec2(i, j-1);
    }

    int top_Down2(int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0 )
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = top_Down2(i - 1, j, dp) +
                top_Down2( i, j - 1, dp);
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
        for (int i = m ; i >= 0; i--) {
            for (int j = n ; j >= 0; j--) {
                if(i==m && j==n) {dp[m][n]=1;continue;}
                int right=0,down=0;
                if(i+1<=m){
                    down=dp[i+1][j];
                }
                if(j+1<=n){
                    right=dp[i][j+1];
                }
                dp[i][j] = down + right;
            }
        }
        return dp[0][0];
    }

    int no_Space(int m, int n) {
       
        int []dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = m - 2; i >= 0; i--) {
            int right=0;
            for (int j = n - 1; j >= 0; j--) {
                int curr = dp[j] + right;
                right=curr;
                dp[j]=right;
            }
        }
        return dp[0];
    }
}