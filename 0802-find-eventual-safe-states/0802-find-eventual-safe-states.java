class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj ){
        int V =adj.length;
        boolean [] safe=new boolean[V];
        boolean [] path=new boolean[V];
        boolean [] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,visited,path,i,safe);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    
    boolean dfs(int[][] adj,boolean [] visited,boolean [] path,int node,boolean [] safe){
        path[node]=true;
        visited[node]=true;
        for(int i:adj[node]){
            if(!visited[i]){
                if(dfs(adj,visited,path,i,safe)){
                    return true;
                }
            }
            else{
                if(path[i]){
                    return true;
                }
            }
        }
        path[node]=false;
        safe[node]=true;
        return false;
    }
}