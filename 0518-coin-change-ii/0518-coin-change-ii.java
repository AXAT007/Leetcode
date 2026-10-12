class Solution {
    public int change(int amount, int[] coins) {
        // return help(coins,amount,0);

        return tabulation(coins,amount);
            
    }

        int memoiz(int[] coins, int i, int amount,int[][] dp)  {
    if (amount == 0) return 1;
    if (i == coins.length|| amount<0) return 0;

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
    int notTake = memoiz(coins, i + 1, amount,dp);

    int take=0;
    if (coins[i] <= amount) {
        take = memoiz(coins, i, amount - coins[i],dp);
    }

    return dp[i][amount]=(take +notTake);

}

int tabulation(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];

    // Base case: using only the first coin
    for (int coin = 0; coin <= amount; coin++) {
        if (coin % coins[0] == 0) {
            dp[0][coin] = 1;
        } 
    }

    for (int i = 1; i < n; i++) {
        for (int coin = 0; coin <= amount; coin++) {
            if( coins[i]>coin){
                dp[i][coin]=dp[i-1][coin];
            }
            else{
            int notTake = dp[i - 1][coin];

            int take =0 ;
            take =  dp[i][coin -coins[i]];
         
            dp[i][coin] = (take + notTake);
        }}
    }

    return dp[n - 1][amount] ;
}

int no_Space(int[] coins, int amount){
    int n=coins.length;
    int[] dp=new int[amount+1];
    for(int i=0;i<=amount;i++){
        if(i%coins[0]==0) dp[i]=i/coins[0];
        else dp[i]=1000000000;
    }
    for(int i=0;i<n;i++){
        for(int coin=amount;coin>=coins[i];coin--){
            int notTake=dp[coin];
            int take=100000000;
            if(coin>=coins[i]){
                take=coin/coins[i];
                if(dp[coin%coins[i]]!=100000000){
                    take+=dp[coin%coins[i]];
                }
            }
            dp[coin]=Math.min(take,notTake);
        }
    }
    return dp[amount]>=100000000? -1:dp[amount];
}
   int help(int [] coins,int amount ,int i ){
        if(amount==0){
            return 1;
        }
        if(i==coins.length ||  amount<0){
            return 0;
        }

        int include=help(coins,amount-coins[i],i);
        int exclude=help(coins,amount,i+1);
        return include+exclude;
    }
}