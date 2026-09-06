class Solution {

    int getParent(int [] parent,int u){
        if(parent[u]==u) return u;
        return parent[u]=getParent(parent,parent[u]);
    }

    boolean unionByRank(int [] parent,int [] rank,int u,int v){
        int pu=getParent(parent,u);
        int pv=getParent(parent,v);
        if(pu==pv) return true;
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
        return false;
    }
    public int makeConnected(int n, int[][] connections) {
        
        boolean [] visited=new boolean[n];
        int[] rank=new int[n];
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int cable=connections.length;
        for(int []e:connections){
            int u=e[0];
            int v=e[1];
            if(!unionByRank(parent,rank,u,v)){
                cable--;
            }
                
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:parent){
               set.add(getParent(parent, i));
        }
        if(cable<set.size()-1) return -1;
        return set.size()-1;
    }
}