class Solution {
    public int[] rearrangeArray(int[] nums) {
        // ture -> +ve 
        // false -> -ve
        
        // boolean flag = false;
        // if(nums[0]>=0){
        //     flag=true;
        // }
        // int j=0;
        // for(int i=1;i<nums.length;i++){
        //     if(flag){
        //         if(nums[i]<0){
        //             j++;
        //             flag=false;
        //             swap(nums,i,j);
        //         }
        //     }
        //     else{
        //         if(nums[i]>=0){
        //             j++;
        //             flag=true;
        //             swap(nums,i,j);
        //         }
        //     }
        // }
        // return nums;

        int n=nums.length;
        int [] ans=new int[n];
        int i=0;
        for(int val:nums){
            if(val>=0){
                ans[i]=val;
                i=i+2;
            }
        }
        i=1;
        for(int val:nums){
            if(val<0){
                ans[i]=val;
                i=i+2;
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