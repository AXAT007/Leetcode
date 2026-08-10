class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return check(grid,0,0,0);
    }
    boolean check(int [][] grid,int i,int j,int term){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length){
            return false;
        }
        if(grid[i][j]==grid.length*grid.length-1 && grid[i][j]==term){
            return true;
        }
        if(grid[i][j]!=term){
            return false;
        }
        return (check(grid,i-1,j-2,term+1) || check(grid,i-1,j+2,term+1) || check(grid,i+1,j-2,term+1) || check(grid,i+1,j+2,term+1) || check(grid,i-2,j-1,term+1) || check(grid,i-2,j+1,term+1) || check(grid,i+2,j+1,term+1) || check(grid,i+2,j-1,term+1));
    }
}

//  check(grid,i-1,j-2,term+1) || check(grid,i-1,j+2,term+1) || check(grid,i+1,j-2,term+1) || check(grid,i+1,j+2,term+1) || check(grid,i-2,j-1,term+1) || check(grid,i-2,j+1,term+1) || check(grid,i+2,j+1,term+1) || check(grid,i+2,j-1,term+1)
