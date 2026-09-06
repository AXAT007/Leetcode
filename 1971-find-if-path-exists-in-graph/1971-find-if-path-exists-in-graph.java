class Solution {

// dsu

    int getParent(int [] parent,int u){
        if(parent[u]==u) return u;
        return parent[u]=getParent(parent,parent[u]);
    }

    void unionByRank(int [] parent,int [] rank,int u,int v){
        int pu=getParent(parent,u);
        int pv=getParent(parent,v);
        if(pu==pv) return ;
        if(rank[pu]==rank[pv]){
            rank[pu]++;
            parent[pv]=pu;
        }
        else if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        }
        else{
            parent[pv]=pu;
        }
    }
 
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source==destination )return true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        // for(int []e :edges){
        //     adj.get(e[0]).add(e[1]);
        //     adj.get(e[1]).add(e[0]);
        // }
        // boolean [] visited=new boolean[n];
        // return dfs(adj,visited,source,destination);
        // return bfs(adj,visited,source,destination);
        return DSU_unionFind(adj,edges,n,source,destination);
    }

    boolean DSU_unionFind(ArrayList<ArrayList<Integer>> adj ,int [][] edges,int n,int src, int dest){
        for(int []e :edges){
            adj.get(e[0]).add(e[1]);
        }
        int[] rank=new int[n];
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int u=0;u<n;u++){
            for(int v:adj.get(u)){
                unionByRank(parent,rank,u,v);
                if(getParent(parent,src)==getParent(parent,dest)){
                    return true;
                }
            }
        }
        return false;
        
    }

    boolean bfs(ArrayList<ArrayList<Integer>> adj ,boolean [] visited,int source, int destination){
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==destination) return true;
            for(int neigbour:adj.get(node)){
                if(!visited[neigbour]){
                    q.offer(neigbour);
                    visited[neigbour]=true;
                }    
            }
        }
        return false;
    }
    boolean dfs(ArrayList<ArrayList<Integer>> adj ,boolean [] visited,int s,int d){
        if(s==d) return true;
        visited[s]=true;
        for(int n:adj.get(s)){
            if(!visited[n]){
                if(dfs(adj,visited,n,d)){
                    return true;
                }
            }
        }
        return false;
    }
}