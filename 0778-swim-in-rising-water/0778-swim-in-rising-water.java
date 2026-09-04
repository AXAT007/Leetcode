class Solution {
    public int swimInWater(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        // boolean [][] visited=new boolean[n][m];
        int [][] dist=new int[n][m];
        for(int []d:dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        int [] getRow={-1,0,1,0};
        int [] getCol={0,-1,0,1};
        PriorityQueue<int []> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.offer(new int[]{0,0,grid[0][0]});
        // int ans=grid[0][0];
        // visited[0][0]=true;
        while(!q.isEmpty()){
            int r=q.peek()[0];
            int c=q.peek()[1];
            int dis=q.peek()[2];
            if(r==n-1 && c== m-1) return dis;;
            if(dis>grid[r][c]){

            }
            // visited[r][c]=true;
            q.poll();
            // int []min={0,0,Integer.MAX_VALUE};
            for(int i=0;i<4;i++){
                int nr=r+getRow[i];
                int nc=c+getCol[i];
                 if(nr>=0 && nc>=0 && nr<n && nc<m && dist[nr][nc] >Math.max(dis,grid[nr][nc]) ){     
                    q.offer(new int[]{nr,nc,Math.max(dis,grid[nr][nc])});
                    dist[nr][nc]=Math.max(dis,grid[nr][nc]);
                }
            }
        }
        return -1;
    }
}