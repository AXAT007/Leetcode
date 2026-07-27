class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n=nums.length;
        n/=2;
        for(int val:map.keySet()) {
            if(map.get(val)>n){
                return val;
            }
        }
        return Integer.MAX_VALUE;
    }
}