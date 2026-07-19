class Solution {
    public int[] findErrorNums(int[] nums) {
         int i=0;
        int[] ans=new int[2];     
       
       while(i<nums.length){
        if(nums[i]==nums[nums[i]-1]){
            i++;
        }
        else if(nums[i]!=i+1){
            swap(nums,i,nums[i]-1);
        }
        else{
            i++;
        }
       }
       for(  i=0;i<nums.length;i++){
        if(nums[i]!=i+1){
            ans[0]=nums[i];
            ans[1]=i+1;
        }
       }
        return ans;
    }
    void swap(int [] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}