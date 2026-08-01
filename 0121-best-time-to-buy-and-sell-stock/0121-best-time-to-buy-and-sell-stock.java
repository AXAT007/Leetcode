class Solution {
    public int maxProfit(int[] prices) {
     int min=Integer.MAX_VALUE;
     int ans=0;
     for(int val:prices){
        if(val>min){
            ans=Math.max(ans,val-min);
        }
        else{
            min=val;
        }
     }
     return ans;   
    }
}