class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];  // 1-indexed
        int[] outdegree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            outdegree[a]++;
            indegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1) {
                return i;
            }
        }

        return -1; // no judge found
    }
}