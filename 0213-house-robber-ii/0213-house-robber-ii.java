class Solution {
    public int rob(int[] nums) {
          int n = nums.length;

        if (n == 1) return nums[0];

        // int[] dp1 = new int[n];
        // int[] dp2 = new int[n];

        // Arrays.fill(dp1, -1);
        // Arrays.fill(dp2, -1);

        // int first = robber(nums, 0, n - 2, dp1);
        // int second = robber(nums, 1, n - 1, dp2);

        // return Math.max(first, second);

        return no_Space(nums,n);
    }
    int no_Space(int[] nums,int n){
        if(n==2) return Math.max(nums[0],nums[1]);
        if(n<=3) return Math.max(nums[2],Math.max(nums[0],nums[1])); 
     int prev1=nums[1];   
     int prev2=Math.max(prev1,nums[2]);
     for(int i=3;i<n;i++){
        int curr=Math.max(nums[i]+prev1,prev2);
        prev1=prev2;
        prev2=curr;
     }
     int ans1=prev2;
     
       prev1=nums[0];   
       prev2=Math.max(prev1,nums[1]);
     for(int i=2;i<n-1;i++){
        int curr=Math.max(nums[i]+prev1,prev2);
        prev1=prev2;
        prev2=curr;
     }
     int ans2=prev2;
     return Math.max(ans1,ans2);
    }
    int robber(int [] nums,int start,int end,int[] dp){
        if(start>end) return 0;
        if(start==end) return nums[start];
        if(dp[end]!=-1) return dp[end];
        return dp[end]=Math.max(nums[end]+robber(nums,start,end-2,dp),robber(nums,start,end-1,dp));
    }
}