class Solution {;
		
	
	
	
    	static boolean no_Space(int arr[], int sum){
    	    
    	    
    	    boolean[] dp=new boolean[sum+1];
    	    dp[0]=true;
    	    for(int i=0;i<arr.length;i++){
    	        for(int target=sum;target>=0;target--){
    	    
    	           // boolean notTake=dp[target];
    	            
    	           // boolean take  = false;
    	            if(target - arr[i] >=0 ){
    	                if(dp[target-arr[i]]){
    	                   dp[target] =true;
    	                }
    	            }
    	            
    	        }
    	    }
    	    return dp[sum];
    	}
    	
// 	the standred approach

	static boolean tabulation2(int [] arr, int sum) {
		boolean [][] dp = new boolean[arr.length + 1][sum + 1];
		
		dp[0][0] = true;
		for (int i = 1; i<dp.length; i++) {
			for (int target = 0; target <= sum; target++) {
				
	
	//   not take
				if (dp[i - 1][target]) {
					dp[i][target] = true;
				}
				
				//   take
				// 1 -> just me
				// dp[i][target] = true;
				
				// 2 -> me with prev choice
				if (target>=arr[i-1]) {
					dp[i][target] = dp[i-1][target-arr[i-1]] || dp[i - 1][target];
				}
			}
		}
		
		return dp[arr.length][sum];
	}
	
	
	
// 	tabulation where i made the formula 
// hip hoeowedeje hahahha
	static boolean tabulation(int [] arr, int sum) {
		boolean [][] dp = new boolean[arr.length + 1][sum + 1];
		
		dp[0][0] = true;
		for (int i = 1; i<dp.length; i++) {
			for (int target = 0; target <= sum; target++) {
				
				 if(dp[i-1][target]){
				     dp[i][target]=true;
				     if(target+arr[i-1] <=sum){
				     dp[i][target+ arr[i-1]]=true;
				
				     }
				 }
			}
		}
		
		return dp[arr.length][sum];
	}
	static boolean rec(int[] arr, int sum, int i, int[][] dp) {
		if (sum == 0)
			return true;
		if (i == arr.length || sum < 0)
			return false;
		
		if (dp[i][sum] != 0) {
			return dp[i][sum] == 1;
		}
		
		// 		dp[i][sum] =
		// 		rec(arr, sum - arr[i], i + 1, dp)
		// 		 || rec(arr, sum, i + 1, dp) ?1:-1 ;
		
		// 		return dp[i][sum] == 1;
		
		// 		or
		
		boolean ans = rec(arr, sum - arr[i], i + 1, dp) || rec(arr, sum, i + 1, dp) ;
		dp[i][sum] = ans?1:-1;
		return ans;
	}

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int val: nums){
            sum+=val;
        }
        if(sum%2!=0){
            return false;
        }
        // int[][] dp=new int[nums.length][sum/2 + 1];
        // return solve(nums,0,sum/2,dp);



    		// 		int [][] dp = new int[arr.length][sum + 1];
		// 		return rec(arr, sum, 0, dp);
		
// 		return tabulation(arr, sum);
// 		return tabulation2(arr, sum);
		return no_Space(nums,sum/2);
    }
    boolean solve(int []  nums,int i,int target,int[][] dp){
        if(0> target||i==nums.length){
            return false;
        }
        if(nums[i] == target){
            return true;
        }
        if(dp[i][target]!=0){
            return dp[i][target] ==1;
        }
        boolean ans=(solve(nums,i+1,target-nums[i],dp)||solve(nums,i+1,target,dp));
         dp[i][target]=ans?1:-1;
        return   ans;
    }
}
