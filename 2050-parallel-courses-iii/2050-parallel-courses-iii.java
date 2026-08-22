 
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int [] deg=new int[n+1];
        int [] map=new int[n+1];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] r:relations){
            int a=r[0];
            int b=r[1];
            adj.get(a).add(b);
            deg[b]++;
        }
        Queue<Integer> q=new ArrayDeque<>();

        for(int i=1;i<n+1;i++){
            if(deg[i]==0){
                map[i]=time[i-1];
                q.offer(i);
            }
        }
        int ans=0;
    
            while(!q.isEmpty()){
                int node=q.poll();
                ans=Math.max(ans,map[node]); 
                for(int val:adj.get(node)){
                    if(map[val] < map[node]+time[val-1]){
                        map[val]=map[node]+time[val-1];
                    }
                    deg[val]--;
                    if(deg[val]==0){
                        q.offer(val);
                    }
                }
            }
        return ans;
    }
}