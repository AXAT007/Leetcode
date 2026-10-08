class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MAX_VALUE;

        int [][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        for (int j = m - 1; j >= 0; j--) {
          ans = Math.min(ans, top_Down(grid, n - 1, j,dp));
            // ans = Math.min(ans, rec(grid, n - 1, j));
        }
        return ans;
    }
    int top_Down(int[][] grid, int i, int j,int[][] dp) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return dp[i][j] =grid[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

       return dp[i][j]= grid[i][j] + Math.min(
            top_Down(grid, i - 1, j,dp),
            Math.min(
                top_Down(grid, i - 1, j + 1,dp),
                top_Down(grid, i - 1, j - 1,dp)
            )
        );
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