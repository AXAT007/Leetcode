class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        List<Integer> ans=new ArrayList<>();     
       
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
            ans.add(i+1);
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