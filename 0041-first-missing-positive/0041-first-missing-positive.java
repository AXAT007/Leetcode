class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int i:nums){
            set.add(i);
            max=Math.max(i,max);
        }
        int ans=1;

        while(ans<=max){
            if(set.contains(ans)){
                ans++;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}