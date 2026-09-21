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

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        parent = new int[size];
        rank = new int[size];
        Arrays.fill(parent, -1);
        int[][] mat = new int[n][m];
        int[] count = new int[size];
        int[] getRow = { 0, 1, -1, 0 };
        int[] getCol = { -1, 0, 0, 1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {

                    int curr = m * i + j;
                    if (parent[curr] == -1) {
                        parent[curr] = curr;

                    }
                    for (int k = 0; k < 4; k++) {
                        int ni = i + getRow[k];
                        int nj = j + getCol[k];
                        if (ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == 0)
                            continue;

                        int next = m * ni + nj;
                        if (parent[next] == -1) {
                            parent[next] = next;
                        }
                        union(curr, next);
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (parent[i] == -1)
                continue;
            int p = findParent(i);
            count[p]++;
        }

        int ans = 0;

        for (int i = 0; i < size; i++) {
            if (parent[i] != -1) {
                int root = findParent(i);
                ans = Math.max(ans, count[root]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();

                    int val = 1;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + getRow[k];
                        int nj = j + getCol[k];
                        if (ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == 0) {
                            continue;
                        }
                        int c = m * ni + nj;
                         
                        int root = findParent(c);
                        if (set.add(root)) {
                            val += count[root];
                        }
                    }
                    ans = Math.max(val, ans);
                }
            }
        }

        return ans;
    }
}