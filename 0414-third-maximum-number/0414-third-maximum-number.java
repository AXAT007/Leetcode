class Solution {
    public int thirdMax(int[] nums) {
        int first=Integer.MIN_VALUE;
        int sec=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            set.add(curr);
            if(curr>first && curr!=third && curr!= sec){
                third=sec;
                sec=first;
                first=curr;
            }
            else if(sec<curr && curr!=first&& curr!=third){
                third=sec;
                sec=curr;
            }
            else if(curr> third && curr!=first && curr!= sec){
                third=curr;
            }
        }
        if(set.size()<3) return first;
        return third;
//       Arrays.sort(nums);
// int count=0;
// if(nums.length<3) return nums[nums.length-1];
// for (int i = nums.length - 1; i >= 0 ; i--) {
//     if(nums[i])
// }
        // return nums[2];
        // if(nums.length<3){
        //     int ans=0;
        //     for(int x:nums){
        //         ans=Math.max(ans,x);
        //     }
        //     return ans;
        // }
        // PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        //     for(int x:nums){
        //         if(pq.size()>3) pq.poll();
        //         pq.offer(x);
        //     }
        // return pq.poll();
    }
}