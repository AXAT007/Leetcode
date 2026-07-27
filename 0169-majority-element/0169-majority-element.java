class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int curr=nums[0];
        int count=0;
       for(int val:nums){
        if(val==curr){
            count++;
        }
        else{
            count--;
            if(count==0){
                curr=val;
                count=1;
            }
        }
       }
        return curr;
    }
}