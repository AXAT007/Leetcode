class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        // return rec(grid,0,0,grid.length-1,grid[0].length-1);
        // return rec(grid,grid.length-1,grid[0].length-1);
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        // return top_Down(grid,0,0,n-1,m-1,dp);
        return top_Down(grid,n-1,m-1,dp);
    }

    int top_Down(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j== 0){
            return grid[i][j];
        }
        if(i<0 || j<0 ){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=grid[i][j] + Math.min(top_Down(grid,i-1,j,dp),top_Down(grid,i,j-1,dp));
    }


     int top_Down(int[][] grid,int i,int j,int n,int m,int[][] dp){
        if(i==n && j== m){
            return grid[i][j];
        }
        if(i<0 || j<0 || i>n || j>m){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=grid[i][j] + Math.min(top_Down(grid,i+1,j,n,m,dp),top_Down(grid,i,j+1,n,m,dp));
    }


    int rec(int[][] grid,int i,int j,int n,int m){
        if(i==n && j== m){
            return grid[i][j];
        }
        if(i<0 || j<0 || i>n || j>m){
            return Integer.MAX_VALUE;
        }
        return grid[i][j] + Math.min(rec(grid,i+1,j,n,m),rec(grid,i,j+1,n,m));
    }



    int rec(int[][] grid,int i,int j){
        if(i<0 ||j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0){
            return grid[i][j];
        }
        int up=rec(grid,i-1,j);
        int left=rec(grid,i,j-1);
        return  grid[i][j] + Math.min(up,left);
    }
}