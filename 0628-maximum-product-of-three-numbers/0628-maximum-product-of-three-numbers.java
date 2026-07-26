class Solution {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        int n=nums.length;

        int l1=Integer.MIN_VALUE;
        int l2=Integer.MIN_VALUE;
        int l3=Integer.MIN_VALUE;
        int s1=Integer.MAX_VALUE;
        int s2=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>l1){
                int t=l1;
                l1=nums[i];
                int t2=l2;
                l2=Math.max(t,l2);
                l3=Math.max(t2,l3);
            }
            else if(nums[i]>l2){
                int t=l2;
                l2=nums[i];
                l3=Math.max(t,l3);
            }
            else if(nums[i]>l3){
                l3=nums[i];
            }
            if(nums[i]<s1){
                int t=s1;
                s1=nums[i];
                s2=Math.min(s2,t);
            }
            else if(nums[i]<s2){
                s2=nums[i];
            }
        }
        int a1=l1*l2*l3;
        int a2=l1*s1*s2;
        return Math.max(a1,a2);
      
    }
}