class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj ){
        int V =adj.length;
        boolean [] unsafe=new boolean[V];
        boolean [] path=new boolean[V];
        boolean [] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,visited,path,i)){
                    for(int j=0;j<V;j++){
                        if(path[j]){
                            unsafe[j]=true;
                        }
                    }
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!unsafe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    
    boolean dfs(int[][] adj,boolean [] visited,boolean [] path,int node){
        path[node]=true;
        visited[node]=true;
        for(int i:adj[node]){
            if(!visited[i]){
                if(dfs(adj,visited,path,i)){
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
        return false;
    }
}