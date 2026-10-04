class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        return no_Space(cost,n);
        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return bottom_Up(cost,n,dp);
        // return top_Down(cost,dp,n);
        // return rec(cost,dp,n);
        
    }

    int no_Space(int [] cost,int n){
        if(n==0) return cost[0];
        if(n==1){
            return Math.min(cost[0],cost[1]);
        }
        
        int prev1=0;
        int prev2=0;
        for(int i=2;i<=n;i++){
            int curr=Math.min(cost[i-1]+prev1,cost[i-2]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    int bottom_Up(int [] cost,int n,int[] dp){
        if(n==0) return cost[0];
        if(n==1){
            return Math.min(cost[0],cost[1]);
        }
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[n];
    }

   int top_Down(int [] cost,int [] minCost,int n){
    if(n<=1) return 0;
    if(minCost[n]!=-1) return minCost[n] ;
    return minCost[n]=Math.min(cost[n-1]+top_Down(cost,minCost,n-1),cost[n-2]+top_Down(cost,minCost,n-2));
   }

   int rec(int [] cost,int [] minCost,int n){
    if(n<=1) return 0;
    return Math.min(cost[n-1]+rec(cost,minCost,n-1),cost[n-2]+rec(cost,minCost,n-2));
   }
}