class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,  j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                int t=nums[++i];
                nums[i]=nums[j];
                nums[j]=t;
            }
            j++;
        }
        return i+1;
    }
}