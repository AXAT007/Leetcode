class Solution {
    public int splitArray(int[] nums, int k) {
        if(k> nums.length) return -1;
        long s=0;
        long e=0;
        for(int i:nums){
            s=Math.max(i,s);
            e+=i;
        }
        if(nums.length==k){
            return (int)s;
        }

        return bs(nums,k,s,e);
    }

    int bs(int [] arr,int k,long s,long e){
        while(s<=e){
            long mid=s+(e-s)/2;
            if(check(arr,k,mid)){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return (int) s;
    }

    boolean check(int [] arr,int k ,long mid){
        int sum=0;
        int count=1;
        for(int val:arr){
            if(sum+val <=mid){
                sum+=val;
            }
            else{
                count++;
                sum=val;
            }
        }
        return count<=k;
    }
}