import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e : emails) {
            String[] p = e.split("@");
            String local = p[0].split("\\+")[0].replace(".", "");
            set.add(local + "@" + p[1]);
        }
        return set.size();
    }
}