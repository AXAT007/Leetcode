class Solution {
    public int fib(int n) {
        return  no_Extra_Space(n);
    //    return bottom_up(n);
    //    return top_Bottom(n,new int[n+1]);
    }

    int no_Extra_Space(int n){
        if(n<=1) return n;
        int prev1=0;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int next=prev2+prev1;
            prev1=prev2;
            prev2=next;
        }
        return prev2;
    }
    int bottom_up(int n){
        int [] dp=new int[n+1];
        if(n<=1) return n;
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    int top_Bottom(int n,int[] dp){
        if(n==0||n==1)return dp[n]=n;
        if(dp[n]!=0) return dp[n];
        return dp[n]= top_Bottom(n - 1,dp) + top_Bottom(n - 2,dp);
    }
}