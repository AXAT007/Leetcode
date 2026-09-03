class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        // dist[0]=0;
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e:times){
            adj.get(e[0]-1).add(new int[]{e[1]-1,e[2]});
        }
        PriorityQueue<int []>pq=new PriorityQueue<>( (a,b)-> a[1]-b[1]);
        pq.offer(new int[]{k-1,0});
        while(!pq.isEmpty()){
            int node=pq.peek()[0];
            int dis=pq.peek()[1];
            pq.poll();
            if(dis > dist[node]) continue;
            for(int [] a:adj.get(node)){
                int nd=dis+a[1];
                if(nd<dist[a[0]]){
                    dist[a[0]]=nd;
                    pq.offer(new int[]{a[0],nd});
                }
            }
        }
        int ans=0;
        for(int i:dist){
            if(i==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,i);
        }
        return ans;
    }
}