class Pair{
    int a;
    int b;
    Pair(int x,int y){
        a=x;
        b=y;
    }
}
    
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int one=0;
        int dist=1;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    
                // grid[i][j]=-1;
                    q.offer(new Pair(i,j));
                }
                else{
                    grid[i][j]=-1;
                    one++;
                }
            }
        }
        while(one>0&& !q.isEmpty()){
            int size=q.size();
            while(size>0&& one>0){
                int i=q.peek().a;
                int j=q.peek().b;
                q.poll();
                if(isVlaid(i+1,j,grid)){
                    grid[i+1][j]=dist;
                    q.offer(new Pair(i+1,j));
                    one--;
                }
                if(isVlaid(i-1,j,grid)){
                    grid[i-1][j]=dist;
                    q.offer(new Pair(i-1,j));
                    one--;
                }
                if(isVlaid(i,j+1,grid)){
                    grid[i][j+1]=dist;
                    q.offer(new Pair(i,j+1));
                    one--;
                }
                if(isVlaid(i,j-1,grid)){
                    grid[i][j-1]=dist;
                    q.offer(new Pair(i,j-1));
                    one--;
                }
                size--;
            }
            dist++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==-1){
                    grid[i][j]=0;
                }
            }
        }
        
        return grid;
        
    }
    boolean isVlaid(int i,int j,int [][] grid){
        return i>=0&&j>=0&&i<grid.length&&j<grid[i].length&&grid[i][j]== -1;
    }
}