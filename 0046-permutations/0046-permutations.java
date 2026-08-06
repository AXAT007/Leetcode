class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> curr=new ArrayList<>();
          
        List<List<Integer>> result=helper(0, curr,nums);
        return result;
    }
    List<List<Integer>> helper(int j,List<Integer> curr,int []nums){
        List<List<Integer>> ans=new ArrayList<>();
       if(j==nums.length){
         ans.add(new ArrayList<>(curr));
        return ans;
       }
       for(int i=0;i<=j;i++){
        curr.add(i,nums[j]);
        ans.addAll(helper(j+1, curr,nums));
        curr.remove(i); 
       }
       return ans;
    }
}