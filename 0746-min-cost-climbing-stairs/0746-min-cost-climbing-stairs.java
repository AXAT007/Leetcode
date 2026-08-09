class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;

        int [] values=new int[n];
        values[n-1]=cost[n-1];
        values[n-2]=cost[n-2];
        for(int i=n-3;i>=0;i--){
            values[i]=cost[i]+Math.min(values[i+1],values[i+2]);
        }
        return Math.min(values[0],values[1]);    
    }
}