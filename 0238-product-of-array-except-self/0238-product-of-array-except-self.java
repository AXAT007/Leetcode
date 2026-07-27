class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        for(int val:nums){
            prod*=val;
        }
        int zero=0;
        for(int val:nums){
            if(val==0){
                zero++;
            }
            if(zero>=2){
                break;
            }
        }
        int idx=0;
        int pro=1;
        if(zero==1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    pro*=nums[i];
                    nums[i]=0;
                }
                else{
                    idx=i;
                }
            }
            nums[idx]=pro;
            return nums;

        }
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            if(temp!=0){
            nums[i]=prod/nums[i];
            // prod*=temp;
            }
        }
        return nums;
    }
}