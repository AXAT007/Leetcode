class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] arr=new int[n];
        int zeroes=0;
        int prod=1;
        for(int x:nums){
            if(x==0) zeroes++;
            else prod*=x;
        }
        if(zeroes>1) return arr;
        if(zeroes==1){
            for(int i=0;i<n;i++){
                int x=nums[i];
                if(x==0)
                arr[i]=prod;
            }
        }
        else{
            for(int i=0;i<n;i++){
                arr[i]=prod/ nums[i];
            }
        }
        return arr;
    }
}