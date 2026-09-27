class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        //         if (grid[0][0] == 0) {
        //             pq.offer(new int[] { 0, 0, 0 });

        // visited[0][0]=0;
        //         } else {

        // visited[0][0]=1;
        //             pq.offer(new int[] { 0, 0, 1 });
        //         }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        visited[0][0] = grid[0][0];

        pq.offer(new int[] { 0, 0, grid[0][0] });
        int[][] getCell = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        while (!pq.isEmpty()) {
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int dist = pq.peek()[2];
            pq.poll();
            if (r == n - 1 && c == m - 1)
                return dist;
            for (int i = 0; i < 4; i++) {
                int nr = r + getCell[i][0];
                int nc = c + getCell[i][1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {

                    // if (grid[nr][nc] == 1) {
                    //     if (visited[nr][nc] > dist + 1) {
                    //         pq.offer(new int[] { nr, nc, dist + 1 });
                    //         visited[nr][nc] = dist + 1;
                    //     }
                    // } else {
                    //     if (visited[nr][nc] > dist) {
                    //         visited[nr][nc] = dist;
                    //         pq.offer(new int[] { nr, nc, dist });
                    //     }
                    // }
                    int newDist = dist + grid[nr][nc];

                    if (visited[nr][nc] > newDist) {

                        visited[nr][nc] = newDist;

                        pq.offer(new int[] {
                                nr, nc, newDist
                        });
                    }
                }
            }
        }
        return -1;
    }
}