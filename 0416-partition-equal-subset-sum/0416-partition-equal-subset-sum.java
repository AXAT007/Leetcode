class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int val: nums){
            sum+=val;
        }
        if(sum%2!=0){
            return false;
        }
        int[][] dp=new int[nums.length][sum/2 + 1];
        return solve(nums,0,sum/2,dp);
    }
    boolean solve(int []  nums,int i,int target,int[][] dp){
        if(0> target||i==nums.length){
            return false;
        }
        if(nums[i] == target){
            return true;
        }
        if(dp[i][target]!=0){
            return dp[i][target] ==1;
        }
        boolean ans=(solve(nums,i+1,target-nums[i],dp)||solve(nums,i+1,target,dp));
         dp[i][target]=ans?1:-1;
        return   ans;
    }
}