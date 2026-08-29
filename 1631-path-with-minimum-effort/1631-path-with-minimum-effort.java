class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> q=new PriorityQueue<>((a,b)->a[2]-b[2] );
        int n=heights.length;
        int m=heights[0].length;
        int [][] ans=new int[n][m];
        
        for(int []arr:ans){
            Arrays.fill(arr,Integer.MAX_VALUE);
            
        }
        ans[0][0]=0;
        int [] ra={-1,1,0,0};
        int [] ca={0,0,-1,1};
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int maxeff=q.peek()[2];
            q.poll();
            if(row==n-1&&col==m-1) return ans[n-1][m-1];

            for(int i=0;i<4;i++){
                int nr=row+ra[i];
                int nc=col+ca[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<m){
                    int new_eff=Math.max(maxeff,Math.abs(heights[nr][nc]-heights[row][col]));
                    
                    if(ans[nr][nc]>new_eff){
                        ans[nr][nc]=new_eff;
                        q.offer(new int[]{nr,nc,new_eff});
                    }
                }
            }
        }
        return ans[n-1][m-1];
    }
}