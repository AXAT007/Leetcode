class Solution {
    int[] parent;
    int[] rank;

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        if (rank[pu] == rank[pv]) {
            parent[pv] = pu;
            rank[pu]++;
        }

        else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
        return true;
    }

    public int removeStones(int[][] stones) {
        int n = 0;
        int m = 0;
        for (int[] e : stones) {
            int u = e[0];
            int v = e[1];
            n = Math.max(n, u);
            m = Math.max(m, v);
        }
        n++;
        m++;
        parent = new int[n + m];
        rank = new int[n + m];
        Arrays.fill(parent, -1);

        // int components = 0;

        // for (int[] e : stones) {

        //     int u = e[0];
        //     int v = e[1] + n;

        //     if (parent[u] == -1) {
        //         parent[u] = u;
        //         components++;
        //     }

        //     if (parent[v] == -1) {
        //         parent[v] = v;
        //         components++;
        //     }

        //     if (union(u, v)) {
        //         components--;
        //     }
        // }

        // return stones.length - components;

        for(int []e :stones){

            int u=e[0];
            int v=e[1]+n;
            if(parent[u]==-1){
                parent[u]=u;
            }
            if(parent[v]==-1){
                parent[v]=v;
            }
            union(u,v);

            // if(union(u,v)){
            //     ans++;
            //     System.out.println(" could not connect ");
            // }
            // else{
            //     count++;
            //     System.out.println(" connect ");
            // }
        }

        // System.out.println(" ans : "+ ans);
        // System.out.println(" count : "+ count);


        int uParent=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1) continue;
            else if(parent[i]==i) uParent++;
        }

        // System.out.println(" ans : "+ ans);
        // System.out.println(" count : "+ count);

        return stones.length-uParent;
    }
}