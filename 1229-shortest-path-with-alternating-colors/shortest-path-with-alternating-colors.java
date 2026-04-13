import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] red = new ArrayList[n], blue = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }

        for (int[] e : redEdges) red[e[0]].add(e[1]);
        for (int[] e : blueEdges) blue[e[0]].add(e[1]);

        int[] res = new int[n];
        Arrays.fill(res, -1);

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][2]; // 0=red, 1=blue

        q.offer(new int[]{0, 0}); // last red
        q.offer(new int[]{0, 1}); // last blue
        vis[0][0] = vis[0][1] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                int node = cur[0], color = cur[1];

                if (res[node] == -1) res[node] = steps;

                // alternate color
                List<Integer>[] nextGraph = (color == 0) ? blue : red;
                int nextColor = 1 - color;

                for (int nei : nextGraph[node]) {
                    if (!vis[nei][nextColor]) {
                        vis[nei][nextColor] = true;
                        q.offer(new int[]{nei, nextColor});
                    }
                }
            }
            steps++;
        }

        return res;
    }
}