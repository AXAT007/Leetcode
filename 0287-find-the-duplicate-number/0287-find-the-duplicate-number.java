/*class Solution {
    public int findDuplicate(int[] nums) {
        //  if(nums.length==2) return nums[0];
        int slow=0;
        int fast=0;
        // while( slow==fast){
        //     if(slow==fast){
        //         return nums[fast];
        //     }
        //     slow=nums[slow+1];
        //     fast=nums[fast+2];
        
        //     if(slow==nums.length-1){
        //         slow=0;
        //     }
        //     if(fast==nums.length-1){
        //         fast=1;
        //     }
        //     if(fast==nums.length-2){
        //         fast=0;
        //     }
        //  }


        // full on cheating coulfnt understd it
        do {
    slow = nums[slow];          // one step
    fast = nums[nums[fast]];    // two steps
} while (slow != fast);
        return nums[fast];
    }
}*/



// ? cheat cheat cheat thst is all u know
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}