class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][]dp=new int[triangle.size()][];
        for(int i=0;i<triangle.size();i++){
            dp[i]=new int[triangle.get(i).size()];
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        // return solve(triangle,0,0);
        
        solve(triangle,dp,0,0);        
        return dp[0][0];
    }

    void solve(List<List<Integer>> triangle,int [][]dp,int row,int col){   
        if(row==triangle.size()-1){
            dp[row][col]= triangle.get(row).get(col);
            return;
        }
        
        int i_term=0;
        int i_P_term=0;
        
        if(dp[row+1][col]==Integer.MAX_VALUE){
            solve(triangle,dp,row+1,col);
        }
        i_term=dp[row+1][col];
        if(dp[row+1][col+1]==Integer.MAX_VALUE){
            solve(triangle,dp,row+1,col+1);
        }
        i_P_term=dp[row+1][col+1];
        int curr=triangle.get(row).get(col);
        int from_Below=Math.min(i_term,i_P_term);
        dp[row][col]=curr+from_Below;
        return;

    }
    int solve(List<List<Integer>> triangle,int row,int col){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        int i_term=solve(triangle,row+1,col);
        int i_P_term=solve(triangle,row+1,col+1);
        int curr=triangle.get(row).get(col);
        int from_Below=Math.min(i_term,i_P_term);
        
        return curr+from_Below;
    }


    // first thinking dont frember what was trying to do
    // int solve(List<List<Integer>> triangle,int sum,int row,int col){
    //     if()
    // }
}