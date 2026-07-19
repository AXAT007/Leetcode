class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length ){
            if(nums[i]==nums.length){
                swap(nums,i,nums.length-1);
            }
            else if(nums[i]!=i){
                swap(nums,i,nums[i]);
            }
            if(nums[i]==i || nums[i]==nums.length){
                i++;
            }
        }
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==nums.length){
    //             // swap(nums,nums.length-1,i)
    //             continue;
    //         }
    //         else if(nums[i]!=i){
    //             swap(nums,i,nums[i]);
    //         }
        
    // }

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