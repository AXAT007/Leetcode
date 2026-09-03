class Tuple{
    int a;
    int b;
    int wt;
    Tuple(int a,int b,int c){
        this.a=a;
        this.b=b;
        wt=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Tuple> q=new ArrayDeque<>();
        int [] getRow={-1,0,0,1,-1,-1,1,1};
        int [] getCol={0,-1,1,0,-1,1,-1,1};
        if(grid[0][0]==1|| grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }  
        if(grid.length == 1 && grid[0].length == 1){
    return 1;
}
        // grid[grid.length-1][grid[0].length-1]=Integer.MAX_VALUE;

        int ans=Integer.MAX_VALUE;
        q.offer(new Tuple(0,0,1));
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        visited[0][0]=true;
        while(!q.isEmpty()){
            int r=q.peek().a;
            int c=q.peek().b;
            int nwt=(q.peek().wt)+1;
            q.poll();
           for(int i = 0; i < 8; i++){

    int nr = r + getRow[i];
    int nc = c + getCol[i];

    if(nr == grid.length - 1 && nc == grid[0].length - 1) {
        ans = Math.min(ans, nwt);
        return ans;
    }
    else if(nr >= 0 && nc >= 0 &&
            nr < grid.length && nc < grid[0].length &&
            grid[nr][nc] == 0 && !visited[nr][nc]) {

        q.offer(new Tuple(nr, nc, nwt));
        visited[nr][nc] = true;
    }
}
        }if(ans==Integer.MAX_VALUE) return -1;
        return  ans;
    }
}