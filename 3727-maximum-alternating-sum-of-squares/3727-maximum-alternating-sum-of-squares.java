class Solution {
    public long maxAlternatingSum(int[] nums) {
     long ans=0;
     for(int i=0;i<nums.length;i++){
        nums[i]=nums[i]*nums[i];
     }
     Arrays.sort(nums);
     int j=1;
     int[] temp=new int[nums.length];
     for(int i=0;i<nums.length/2;i++){
        if(j>=nums.length) break;
        temp[j]=nums[i];
        j+=2;
     }
     j=0;
     for(int i=nums.length-1;i>=nums.length/2;i--){
        if(j>=nums.length) break;
        temp[j]=nums[i];
        j+=2;
     }
     for(int i=0;i<nums.length;i+=2){
        long minus=0;
        if(i+1<nums.length){
            minus=temp[i+1] ;
        }
        long plus=temp[i] ;
        ans= ans+ plus - minus;  
     }
     System.out.println(Arrays.toString(temp));

     return ans;
    }
}