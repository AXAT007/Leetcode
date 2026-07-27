class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int n=nums.length/2;
        int count=1;
        for(int i=1;i<nums.length;i++){
              if(nums[i]==nums[i-1]){
                    count++;
                     if(count> n) {
                return nums[i];
            }
                }
                else{
                    count=1;
                }
            }
         return nums[nums.length-1];
    }
}