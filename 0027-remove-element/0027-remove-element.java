class Solution {
    public int removeElement(int[] nums, int val) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                swap(nums,i,++j);
            }
        }
        return j+1;
    }
    void swap(int []nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}