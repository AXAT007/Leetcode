class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int val:nums){
            largest=Math.max(largest,val);
            smallest=Math.min(smallest,val);
        }
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        int x=nums[0];
        int i=0;
        while(i<nums.length){
            if(nums[i]==x){
                i++;
            }
            else{
                ans.add(x);
            }
            x++;
        }
        return ans;
    }
}