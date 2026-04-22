import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), r);
        return r;
    }
    void dfs(int s, int n, int k, List<Integer> t, List<List<Integer>> r) {
        if (k == 0) { r.add(new ArrayList<>(t)); return; }
        for (int i = s; i <= n; i++) {
            t.add(i);
            dfs(i + 1, n, k - 1, t, r);
            t.remove(t.size() - 1);
        }
    }
}