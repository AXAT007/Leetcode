class Solution {
    public void unionByRank(int [] parent,int [] rank,int u,int v){
        int pu=findParent(parent,u);
    int pv=findParent(parent,v);
    if(pu==pv){
      // will form cycle , Do nothing
      return  ;
    }
    int ru=rank[pu];
    int rv=rank[pv];
    if(ru==rv){
      parent[pv]=pu;
      rank[pu]++;
    }
    else if(ru<rv){
      parent[pu]=pv;
    }
    else{
      parent[pv]=pu;
    }
    return ;
  }  
  
public int findParent(int [] parent,int node){
    if(node==parent[node]){
      return node;  
    }
    return parent[node]=findParent(parent,parent[node]);
 }

    public int findCircleNum(int[][] isConnected) {
        
        int V=isConnected.length;
         int [] rank=new int[V+1];
         int [] parent=new int[V+1];
        for(int i=0;i<=V;i++){
            parent[i]=i;
         }
       
        for(int u=0;u<V;u++){
            for(int v=u+1;v<V;v++){
               if(isConnected[u][v] == 1){
            unionByRank(parent, rank, u, v);
        }
            }
        }
        int count =0;
        HashSet<Integer> set=new HashSet<>();
       for(int i = 0; i < V; i++){
    set.add(findParent(parent, i));
       }
        return set.size();
    }
     
}