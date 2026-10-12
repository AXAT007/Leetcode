class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0);
    }

    int rec(int[] nums,int target,int i){
        if(i==nums.length && target==0) return 1;
        if(i==nums.length )  return 0;
        int plus=rec(nums,target+nums[i],i+1);
        int minus=rec(nums,target-nums[i],i+1);
        return plus + minus;
    }
}
