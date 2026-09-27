 
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] getRow = { -1, 0, 0, 1, -1, -1, 1, 1 };
        int[] getCol = { 0, -1, 1, 0, -1, 1, -1, 1 };
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }

        int ans = 1;
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = size; i > 0; i--) {
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                for (int j = 0; j < 8; j++) {

                    int nr = r + getRow[j];
                    int nc = c + getCol[j];

                    if (nr == grid.length - 1 && nc == grid[0].length - 1) {
                        return ans+1;
                    } else if (nr >= 0 && nc >= 0 &&
                            nr < grid.length && nc < grid[0].length &&
                            grid[nr][nc] == 0) {

                        q.offer(new int[] { nr, nc });
                        grid[nr][nc] = 1;
                    }
                }
            }
            ans++;
        }
        return -1;

    }
}