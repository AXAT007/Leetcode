class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // return rec(nums,target,0);
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        int[][] dp=new int[nums.length][2*sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        if (Math.abs(target) > sum) return 0;
        return memoiz(nums,target,0,dp,sum);
         
    }

    
    int memoiz(int[] nums,int target,int i,int[][] dp,int offset){
        if(i==nums.length && target==0) return 1;
        if(i==nums.length )  return 0;

            if (Math.abs(target) > offset) return 0;

        if(dp[i][target+ offset]!=-1) return dp[i][target+ offset];
        int plus=memoiz(nums,target+nums[i],i+1,dp,offset);
        int minus=memoiz(nums,target-nums[i],i+1,dp,offset);
        return dp[i][target+ offset]= plus + minus;
    }

    int rec(int[] nums,int target,int i){
        if(i==nums.length && target==0) return 1;
        if(i==nums.length )  return 0;
        int plus=rec(nums,target+nums[i],i+1);
        int minus=rec(nums,target-nums[i],i+1);
        return plus + minus;
    }
}
