class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
       int[] dp=new int[n] ;
       Arrays.fill(dp,-1);

       return bottom_Up(nums,0,dp);
    //    return top_Bottom(nums,0,dp);
    //    return rec(nums,0);  
    }

    int bottom_Up(int[] nums,int i,int[] dp){
        // if(i>=nums.length) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[1],nums[0]);
        dp[0] =nums[0];
        dp[1]= Math.max(nums[1],nums[0]);
        for( i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[i-1];
    }


    int top_Bottom(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=Math.max(nums[i]+top_Bottom(nums,i+2,dp),top_Bottom(nums,i+1,dp));
        return dp[i];
    }

    int rec(int[] nums,int i){
        if(i>=nums.length) return 0;
        int sum=Math.max(nums[i]+rec(nums,i+2),rec(nums,i+1));
        return sum;
    }
}


/*
class Solution {
    public int rob(int[] nums) {
   int  ans=0;
    int t=0;
    return help(nums,ans,t,0);
    // return ans;
    }

    
    int help(int [] nums,int  ans,int temp,int i){
        if(i>=nums.length){
            ans=Math.max(ans,temp);
            return ans;
        }
        temp+=nums[i];
        int a1=help(nums,ans,temp,i+2);
        temp -=nums[i];
        int a2=help(nums,ans,temp,i+1);
        return Math.max(a1,a2);
    }
}
*/

  /*
    int[] ans={0};
    int[] t={0};
    help(nums,ans,t,0);
    return ans[0];
    }

    // if i take current element then do recursive call 
    void help(int [] nums,int[] ans,int[] temp,int i){
        if(i>=nums.length){
            ans[0]=Math.max(ans[0],temp[0]);
            return ;
        }
        temp[0]+=nums[i];
        help(nums,ans,temp,i+2);
        temp[0] -=nums[i];
        help(nums,ans,temp,i+1);
        return;
    }

*/

    //  public int rob(int[] nums) {
    //     int a1=help1(nums,0,0);
    //     int a2=help2(nums,0,1);
    //     return Math.max(a1,a2);
    // }
    // int help1(int [] nums,int ans,int i){
    //     if(i>=nums.length){
    //         return ans;
    //     }
    //     ans+=nums[i];
    //     return help1(nums,ans,i+2);
    // }
    // int help2(int [] nums,int ans,int i){
    //     if(i>=nums.length){
    //         return ans;
    //     }
    //     ans+=nums[i];
    //     return help2(nums,ans,i+2);
    //  }
// }
