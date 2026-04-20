class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        for (int[] e : edges)
            p[find(p, e[0])] = find(p, e[1]);

        return find(p, s) == find(p, d);
    }

    private int find(int[] p, int x) {
        return p[x] == x ? x : (p[x] = find(p, p[x]));
    }
}