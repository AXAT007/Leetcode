class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []e :edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean [] visited=new boolean[n];
        // return dfs(adj,visited,source,destination);

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

    boolean bfs(){
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