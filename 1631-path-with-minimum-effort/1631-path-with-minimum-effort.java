class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> q=new PriorityQueue<>((a,b)->a[2]-b[2] );
        int n=heights.length;
        // int m=
        int [][] ans=new int[n][];
        
        boolean [][] visited=new boolean[n][];
        for(int i=0;i<heights.length;i++){
            ans[i]=new int[heights[i].length];
            visited[i]=new boolean[heights[i].length];
        }
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
            if(row==n&&col==heights[n-1].length-1) return ans[n-1][heights[n-1].length-1];
            visited[row][col]=true;
            for(int i=0;i<4;i++){
                int nr=row+ra[i];
                int nc=col+ca[i];
                if(nr>=0&&nc>=0&&nr<n&&nc<heights[nr].length&&!visited[nr][nc]){
                    int diff=Math.abs(heights[nr][nc]-heights[row][col]);
                    diff=Math.max(diff,maxeff);
                    if(ans[nr][nc]>diff){
                        ans[nr][nc]=diff;
                        q.offer(new int[]{nr,nc,diff});
                    }
                }
            }
        }
        return ans[n-1][heights[n-1].length-1];
    }
}