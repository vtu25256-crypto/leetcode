import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // Build graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // b -> a
        }

        int[] visited = new int[numCourses]; // 0,1,2

        // Check each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) return false; // cycle
        if (visited[node] == 2) return true;  // already safe

        visited[node] = 1; // mark visiting

        for (int nei : graph.get(node)) {
            if (!dfs(graph, visited, nei)) return false;
        }

        visited[node] = 2; // mark safe
        return true;
    }
}