class Solution {
    public int fib(int n) {
        int [] dp=new int[n+1];
        // Arrays.fill(dp,-1);
      return F(n,dp)  ;
    }
    int F(int n,int[] dp){
        if(n==0||n==1)return dp[n]=n;
        if(dp[n]!=0) return dp[n];
        return dp[n]= F(n - 1,dp) + F(n - 2,dp);
    }
}