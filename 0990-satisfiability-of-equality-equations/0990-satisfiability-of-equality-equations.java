class Solution {
    int[] parent = new int[26];
    int[] rank = new int[26];

    int find(int idx) {
        if (parent[idx] == idx)
            return idx;
        return parent[idx] = find(parent[idx]);
    }

    boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return false;
        if (rank[pu] == rank[pv]) {
            rank[pu]++;
            parent[pv] = pu;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {
        Arrays.fill(parent, -1);

        for (String s : equations) {

            char a = s.charAt(0);
            char b = s.charAt(3);

            if (parent[a - 'a'] == -1) {
                parent[a - 'a'] = a - 'a';
            }

            if (parent[b - 'a'] == -1) {
                parent[b - 'a'] = b - 'a';
            }

            if (s.charAt(1) == '=') {
                union(a - 'a', b - 'a');
            }
        }

        for (String s : equations) {

            char a = s.charAt(0);
            char b = s.charAt(3);

            if (s.charAt(1) == '!') {
                if (find(a - 'a') == find(b - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}