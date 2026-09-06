// class Solution {
// int[] rank;
// int[] parent;
//     int getParent(int [] parent,int u){
//         if(parent[u]==u) return u;
//         return parent[u]=getParent(parent,parent[u]);
//     }

//     boolean unionByRank(int [] parent,int [] rank,int u,int v){
//         int pu=getParent(parent,u);
//         int pv=getParent(parent,v);
//         if(pu==pv) return true;
//         if(rank[pu]==rank[pv]){
//             rank[pu]++;
//             parent[pv]=pu;
//         }
//         else if(rank[pu]<rank[pv]){
//             parent[pu]=pv;
//         }
//         else{
//             parent[pv]=pu;
//         }
//         return false;
//     }
//     public int makeConnected(int n, int[][] connections) {
//         if(connections.length<n-1) return -1;

//         int[] rank=new int[n];
//         int[] parent=new int[n];
//         for(int i=0;i<n;i++){
//             parent[i]=i;
//         }
//         int components=n;
//         int cable=connections.length;
//         for(int []e:connections){
//             int u=e[0];
//             int v=e[1];
//             if(!unionByRank(parent,rank,u,v)){
//                 // cable--;
//                 components--;
//             }
                
//         }
//         return components-1;;
//     }
// }

class Solution {

    int[] rank;
    int[] parent;

    int getParent(int u) {
        if(parent[u] == u) return u;
        return parent[u] = getParent(parent[u]);
    }

    boolean unionByRank(int u, int v) {

        int pu = getParent(u);
        int pv = getParent(v);

        if(pu == pv) return true;

        if(rank[pu] == rank[pv]) {
            rank[pu]++;
            parent[pv] = pu;
        }
        else if(rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else {
            parent[pv] = pu;
        }

        return false;
    }

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1)
            return -1;

        rank = new int[n];
        parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for(int[] e : connections) {
            if(!unionByRank(e[0], e[1])) {
                components--;
            }
        }

        return components - 1;
    }
}