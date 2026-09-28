class Solution {
    public int minCost(int[][] grid) {
        int[][] sign = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][] getCell = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 0 });
        int n = grid.length;
        int m = grid[0].length;
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int costt = curr[2];

            int s = grid[r][c];
            int signRow = r + sign[s][0];
            int signCol = c + sign[s][1];
            if (costt > cost[r][c])
                continue;
            if (r == n - 1 && c == m - 1)
                return costt;
            for (int i = 0; i < 4; i++) {
                int nr = r + getCell[i][0];
                int nc = c + getCell[i][1];
                int ncost = 0;
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (signRow == nr && signCol == nc) {
                        ncost = costt;
                        if (ncost < cost[nr][nc]) {
                            cost[nr][nc] = ncost;
                            q.addFirst(new int[] { nr, nc, ncost });
                        }
                    } else {
                        ncost = costt + 1;
                        if (ncost < cost[nr][nc]) {
                            cost[nr][nc] = ncost;
                            q.addLast(new int[] { nr, nc, ncost });
                        }
                    }
                }
            }
        }
        return -1;
    }
}