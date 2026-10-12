class Solution {
    public int coinChange(int[] coins, int amount) {
    //   int ans= help(coins,amount,0,0);
    //         if(ans==Integer.MAX_VALUE){
    //             return -1;
    //         }
    //         return ans;

    return tabulation(coins,amount);
    }
  int help(int [] coins,int amount ,int i,int count ){
        if(amount==0){
            return count;
        }
        if(i==coins.length ||  amount<0){
            return Integer.MAX_VALUE;
        }

        int include=help(coins,amount-coins[i],i,count+1);
        int exclude=help(coins,amount,i+1,count);
        return Math.min(include,exclude);
    }

    int tabulation(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];

    // Base case: using only the first coin
    for (int coin = 0; coin <= amount; coin++) {
        if (coin % coins[0] == 0) {
            dp[0][coin] = coin / coins[0];
        } else {
            dp[0][coin] = 1000000;
        }
    }

    for (int i = 1; i < n; i++) {
        for (int coin = 0; coin <= amount; coin++) {

            int notTake = dp[i - 1][coin];

            int take = 1000000;
            if (coins[i] <= coin) {
                take = 1 + dp[i][coin - coins[i]];
            }

            dp[i][coin] = Math.min(take, notTake);
        }
    }

    return dp[n - 1][amount] >= 1000000
            ? -1
            : dp[n - 1][amount];
}
}