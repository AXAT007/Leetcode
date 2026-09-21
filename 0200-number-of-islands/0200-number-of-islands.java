class Solution {
    int parent[];
    int[] rank;

    int findParent(int i) {
        if (i == parent[i])
            return i;
        return parent[i] = findParent(parent[i]);
    }

    boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return true;
        if (rank[pu] == rank[pv]) {
            parent[pv] = pu;
            rank[pu]++;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
        return false;
    }

    public int numIslands(char[][] grid) {

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        parent = new int[size];
        rank = new int[size];
        Arrays.fill(parent, -1);

        // int ones=0;
        // for(char[] i:grid){
        //     for(char j:i){
        //         if(j=='1') ones++;
        //     }
        // }
        // int [][] edges= new int[count][2];
        int[] getRow = { 0, 1, -1, 0 };
        int[] getCol = { -1, 0, 0, 1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                     
                    int curr = m * i + j;
                    if (parent[curr] == -1) {
                        parent[curr] = curr;
                        count++;

                    }
                    for (int k = 0; k < 4; k++) {
                        int ni = i + getRow[k];
                        int nj = j + getCol[k];
                        if (ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == '0')
                            continue;

                        int next = m * ni + nj;
                        if (parent[next] == -1) {
                            count++;

                            parent[next] = next;
                        }
                        if (!union(curr, next)) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}