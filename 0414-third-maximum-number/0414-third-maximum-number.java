class Solution {
    public int thirdMax(int[] nums) {
long first = Long.MIN_VALUE;
        long sec = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;


        for(int curr:nums){
            
            
            if (curr == first || curr == sec || curr == third) {
                continue;
            }
            if(curr>first){
                third=sec;
                sec=first;
                first=curr;
            }
            else if(sec<curr){
                third=sec;
                sec=curr;
            }
            else if (curr > third) {
    third = curr;
}
        }
        if(third==Long.MIN_VALUE) return(int) first;
        return (int) third;
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