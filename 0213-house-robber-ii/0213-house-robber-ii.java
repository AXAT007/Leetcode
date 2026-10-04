class Solution {
    public int rob(int[] nums) {
          int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int first = robber(nums, 0, n - 2, dp1);
        int second = robber(nums, 1, n - 1, dp2);

        return Math.max(first, second);
    }
    int robber(int [] nums,int start,int end,int[] dp){
        if(start>end) return 0;
        if(start==end) return nums[start];
        if(dp[end]!=-1) return dp[end];
        return dp[end]=Math.max(nums[end]+robber(nums,start,end-2,dp),robber(nums,start,end-1,dp));
    }
}