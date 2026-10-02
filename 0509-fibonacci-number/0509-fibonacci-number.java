class Solution {
    public int fib(int n) {
      return F(n,new int[n+1])  ;
    }
    int F(int n,int[] dp){
        if(n==0||n==1)return dp[n]=n;
        return dp[n]= F(n - 1,dp) + F(n - 2,dp);
    }
}