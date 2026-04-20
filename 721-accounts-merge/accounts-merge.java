import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        // Initialize
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                parent.put(acc.get(i), acc.get(i));
                owner.put(acc.get(i), name);
            }
        }

        // Union emails
        for (List<String> acc : accounts) {
            String p = find(acc.get(1), parent);
            for (int i = 2; i < acc.size(); i++) {
                parent.put(find(acc.get(i), parent), p);
            }
        }

        // Group emails
        Map<String, TreeSet<String>> map = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(email, parent);
            map.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        // Build result
        List<List<String>> res = new ArrayList<>();
        for (String root : map.keySet()) {
            List<String> list = new ArrayList<>(map.get(root));
            list.add(0, owner.get(root));
            res.add(list);
        }

        return res;
    }

    private String find(String s, Map<String, String> parent) {
        if (!parent.get(s).equals(s))
            parent.put(s, find(parent.get(s), parent));
        return parent.get(s);
    }
}