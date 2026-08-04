class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        HashSet <Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
            largest=Math.max(largest,val);
            smallest=Math.min(smallest,val);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=smallest;i<=largest;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}