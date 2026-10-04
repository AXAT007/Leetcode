class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
       return costt(cost,n,dp);
        // return top_Down(cost,dp,n);
        // return rec(cost,dp,n);
        // return Math.min(costt(cost,0,0,n,dp),costt(cost,0,1,n,dp));
   }
   int top_Down(int [] cost,int [] minCost,int n){
    if(n<=1) {
        minCost[n]=0;
        return 0;
    }
    int left=Integer.MAX_VALUE;
    int right=Integer.MAX_VALUE;

    if(minCost[n-1]!=-1){
        left=minCost[n-1];
    }
    if(minCost[n-2]!=-1){
        right=minCost[n-2];
    }
    
    return minCost[n]=Math.min(cost[n-1]+rec(cost,minCost,n-1),cost[n-2]+rec(cost,minCost,n-2));
   }

   int rec(int [] cost,int [] minCost,int n){
    if(n<=1) return 0;
    return Math.min(cost[n-1]+rec(cost,minCost,n-1),cost[n-2]+rec(cost,minCost,n-2));
    
    // if(n<=1) return minCost[n]=cost[n];
    // if(minCost[n]!=-1) return minCost[n];
    // return minCost[n]= Math.min(cost[n-1]+minCost[n-1],cost[n-2]+minCost[n-2]);
   }
   int costt(int [] cost,int n,int[] dp){
    if(n<=1) return 0;
    if(dp[n]!=-1) return dp[n];
    return dp[n]=Math.min(cost[n-1]+costt(cost,n-1,dp),cost[n-2]+costt(cost,n-2,dp));
   }
}