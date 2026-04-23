import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> r = new ArrayList<>();
        dfs(a, new boolean[a.length], new ArrayList<>(), r);
        return r;
    }
    void dfs(int[] a, boolean[] v, List<Integer> t, List<List<Integer>> r) {
        if (t.size() == a.length) { r.add(new ArrayList<>(t)); return; }
        for (int i = 0; i < a.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            t.add(a[i]);
            dfs(a, v, t, r);
            t.remove(t.size() - 1);
            v[i] = false;
        }
    }
}