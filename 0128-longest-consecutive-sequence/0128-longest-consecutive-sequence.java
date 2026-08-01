class Solution {
    public int longestConsecutive(int[] nums) {
         HashSet<Integer> set=new HashSet<>();
        int ans=0;
        int count=1;
         for(int val:nums){
             set.add(val);
        }
        for(int x:set){
            int val=x;
            
            if(!set.contains(val-1)){
            while(set.contains(val+1)){
                count++;
                val+=1;
            }  
            ans=Math.max(ans,count);
            count=1;
            }
        }
        return ans;
    }
}