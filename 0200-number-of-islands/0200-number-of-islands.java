class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][];
        for(int i=0;i<grid.length;i++){
            visited[i]=new boolean[grid[i].length];
        } 
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,boolean[][] visited,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]=='0'||visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i,j-1);
        dfs(grid,visited,i,j+1);
        dfs(grid,visited,i-1,j);
    }
}