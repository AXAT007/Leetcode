class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
                int[] prev = grid[n - 1].clone();
        int[] curr = new int[m];

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j < m; j++) {

                curr[j] = grid[i][j] + prev[j];

                if (j - 1 >= 0) {
                    curr[j] = Math.min(curr[j],
                            grid[i][j] + prev[j - 1]);
                }

                if (j + 1 < m) {
                    curr[j] = Math.min(curr[j],
                            grid[i][j] + prev[j + 1]);
                }
            }

            prev = curr;
            curr = new int[m];
        }
        int ans = Integer.MAX_VALUE;

        for (int x : prev) {
            ans = Math.min(ans, x);
        }

        return ans;

    }
}

// class Solution {
//     public int minFallingPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[] dp = grid[n - 1].clone();

//         int ans = Integer.MAX_VALUE;

//         for (int i = n - 2; i >= 0; i--) {

//             int left = Integer.MAX_VALUE;

//             for (int j = 0; j < m; j++) {

//                 int curr = Integer.MAX_VALUE;

//                 int dj = j - 1;
//                 // down
//                 int bj = j;
//                 // right
//                 int sj = j + 1;

//                 int down = dp[bj];

//                 if (dj >= 0) {
//                     curr = Math.min(curr, grid[i][j] + left);
//                 }

//                 if (sj < m) {
//                     curr = Math.min(curr, grid[i][j] + dp[sj]);
//                 }

//                 curr = Math.min(curr, grid[i][j] + down);

//                 dp[j] = curr;

//                 // old dp[j] becomes left for next j
//                 left = down;
//             }
//         }

//         for (int x : dp) {
//             ans = Math.min(ans, x);
//         }

//         return ans;
//     }
// }

/*

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = grid[n - 1];

        int ans = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i++) {
            for (int j = 0; j < m; j++) {
                int curr = Integer.MAX_VALUE;
int left=0
                int dj = j - 1;
                //    down
                int bj = j;
                // right
                int sj = j + 1;

                if (dj >= 0) {
                    curr = Math.min(curr, grid[i][j] + dp[dj]);
                }

                if (sj < m) {
                    curr = Math.min(curr, grid[i][j] + dp[sj]);
                }
                curr = Math.min(curr, grid[i][j] + dp[j]);
                dp[j] = curr;
                if (i == 0)
                    return curr;

            }
        }

        for (int x : dp) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}
*/