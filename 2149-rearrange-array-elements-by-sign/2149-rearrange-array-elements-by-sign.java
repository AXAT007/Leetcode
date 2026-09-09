class Solution {
    public int[] rearrangeArray(int[] nums) {
  

        int n=nums.length;
        int [] ans=new int[n];
        int pos=0;
        int neg=1;
        for(int val:nums){
            if(val>=0){
                ans[pos]=val;
                pos=pos+2;
            }
            else{
                ans[neg]=val;
                neg=neg+2;
            }
        }
        return ans;
    }
 
}