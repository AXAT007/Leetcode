class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        permute(n,k,ans,1,result);
        return result;
        }
        void permute(int n ,int k, List<Integer> ans,int i, List<List<Integer>> result){
        if(i>n){
            if(ans.size()==k){
            result.add(new ArrayList<>(ans));
            }
            return;
        }
        ans.add(i);
        permute(n,k, ans,i+1,result);
        ans.removeLast();
        permute(n,k,ans,i+1,result);
    }
}