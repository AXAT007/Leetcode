class Solution {
    public int missingNumber(int[] nums) {
        int last=0;
        int currSum=0;
        int maxSum=0;
        for(int val:nums){
            currSum+=val;
            last=Math.max(last,val);
        }
        if(last!=nums.length){
            last++;
        }
        for(int i=0;i<=last;i++){
            maxSum+=i;
        }
        return maxSum-currSum;
    }
}