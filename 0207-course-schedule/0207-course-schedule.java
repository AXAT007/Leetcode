class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=numCourses;
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        boolean [] visited=new boolean[V];
        boolean [] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(adj,visited,path,i)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean isCycle(ArrayList<ArrayList<Integer>> adj,boolean [] visited,boolean [] path,int node){
        visited[node]=true;
        path[node]=true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                if(isCycle(adj,visited,path,i)){
                    return true;
                }
            }
            if(path[i]){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
}