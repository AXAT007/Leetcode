class Solution {
    public int[] sortedSquares(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                s++;
            }
            else{
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]*=nums[i];
        }
        int [] temp=new int[s];
        int j=0;
        for(int i=s-1;i>=0;i--){
            temp[i]=nums[j++];
        }
        if(s==nums.length){
            return temp;
        }
        int i=0;
         j=s;
        int k=0;
        while(i<s&&j<nums.length){
            if(temp[i]<nums[j]){
                nums[k++]=temp[i];
            i++;
            }else{
                nums[k++]=nums[j];
            
            j++;
            }
        }
        while(i<s){
            nums[k++]=temp[i++];
        }
        while(j<nums.length){
            nums[k++]=nums[j++];
        }
        return nums;
    }
}