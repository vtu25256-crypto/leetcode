import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // assign groups to -1
        for (int i = 0; i < n; i++)
            if (group[i] == -1) group[i] = m++;

        List<List<Integer>> ig = new ArrayList<>(), gg = new ArrayList<>();
        int[] indegI = new int[n], indegG = new int[m];

        for (int i = 0; i < n; i++) ig.add(new ArrayList<>());
        for (int i = 0; i < m; i++) gg.add(new ArrayList<>());

        // build graphs
        for (int i = 0; i < n; i++) {
            for (int p : beforeItems.get(i)) {
                ig.get(p).add(i);
                indegI[i]++;
                if (group[i] != group[p]) {
                    gg.get(group[p]).add(group[i]);
                    indegG[group[i]]++;
                }
            }
        }

        List<Integer> go = topo(gg, indegG), io = topo(ig, indegI);
        if (go.isEmpty() || io.isEmpty()) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int x : io)
            map.computeIfAbsent(group[x], k -> new ArrayList<>()).add(x);

        List<Integer> res = new ArrayList<>();
        for (int g : go)
            if (map.containsKey(g)) res.addAll(map.get(g));

        return res.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> topo(List<List<Integer>> g, int[] indeg) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indeg.length; i++)
            if (indeg[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : g.get(u))
                if (--indeg[v] == 0) q.offer(v);
        }
        return res.size() == indeg.length ? res : new ArrayList<>();
    }
}