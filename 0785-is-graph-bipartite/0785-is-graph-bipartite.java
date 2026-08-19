class Solution {
    public boolean isBipartite(int[][] adj) {
        int V=adj.length;
        int [] colors=new int[V];
        Arrays.fill(colors,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(colors[i]==-1){
                q.offer(i);
                
                colors[i]=0;
                while(!q.isEmpty()){
                    int node=q.poll();
                    
                    for(int j:adj[node]){
                        int col=getColor(colors[node]);
                        if(colors[j]==-1){
                            colors[j]=col;
                            q.offer(j);
                        }
                        else{
                            if(colors[j]!=col){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    int getColor(int col){
        if(col==0){
            return 1;
        }
        return 0;
    }
}