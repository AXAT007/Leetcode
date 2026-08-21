class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=numCourses;
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        Stack<Integer> st=new Stack<>();
        boolean [] visited=new boolean[V];
        boolean [] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(adj,visited,path,i,st)){
                    return new int[0];
                }
            }
        }
        int i=0;
        int [] ans=new int[st.size()];
        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;
    }
    boolean isCycle(ArrayList<ArrayList<Integer>> adj,boolean [] visited,boolean [] path,int node,Stack<Integer> st){
        visited[node]=true;
        path[node]=true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                if(isCycle(adj,visited,path,i,st)){
                    return true;
                }
            }
            if(path[i]){
                return true;
            }
        }
        path[node]=false;
        st.push(node);
        return false;        
    }
}