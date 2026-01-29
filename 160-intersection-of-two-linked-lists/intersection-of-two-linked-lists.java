public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        ListNode p = a, q = b;
        while (p != q) {
            p = (p == null) ? b : p.next;
            q = (q == null) ? a : q.next;
        }
        return p;
    }
}
