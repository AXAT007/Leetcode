class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
         
        helper(0,ans,result,nums);
        return result;
    }
    void helper(int j, List<Integer> curr, List<List<Integer>> result,int []nums){
       if(j==nums.length){
        result.add(new ArrayList<>(curr));
        return ;
       }
       for(int i=0;i<=j;i++){
        curr.add(i,nums[j]);
        helper(j+1,curr,result,nums);
        curr.remove(i); 
       }
    }
}