
//   CYCLIC SORT 


class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length ){
            if(nums[i]==nums.length){
                
            }
            else if(nums[i]!=i){
                swap(nums,i,nums[i]);
            }
            if(nums[i]==i || nums[i]==nums.length){
                i++;
            }
        }
     

    for( i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }

    void swap(int [] nums,int i ,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}