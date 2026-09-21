class Solution {
    public int numIslands(char[][] grid) {
         
        int count =0;
        Queue<int []> q=new ArrayDeque<>();
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        int [][] getCell= { {0,-1},{0,1},{-1,0},{1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    count++;
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int r=q.peek()[0];
                        int c=q.peek()[1];
                        q.poll();
                        for(int k=0;k<4;k++){
                            int nr=r+getCell[k][0];
                            int nc=c+getCell[k][1];
                            if(isValid(grid,nr,nc,visited)){
                                q.offer(new int[]{nr,nc});
                                visited[nr] [nc]=true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public boolean isValid(char[][] grid,int i,int j,boolean [][] visited){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]=='0'||visited[i][j]){
            return false;
        }
        return true;
    }
}