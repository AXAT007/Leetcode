class Solution {
    // public List<List<Integer>> subsets(int[] s) {
    //     List<List<Integer>> result=new ArrayList<>();
    //     List<Integer> ans=new ArrayList<>();
    //     permute(s,ans,0,result);
    //     return result;
    // }
    public List<List<Integer>> subsets(int[] s){
     List< List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        subset2(s,ans);
        return ans;
    }
    void subset2(int [] arr, List< List<Integer>> ans){

        for(int val:arr){
            int n=ans.size();
            System.out.println(n);
            for(int i=0;i<n;i++){
                 List<Integer> curr=ans.get(i);
                curr.add(val);
                ans.add(new ArrayList<>(curr));
                curr.removeLast();
//                ans.add( curr);
            }
        }
    }
}