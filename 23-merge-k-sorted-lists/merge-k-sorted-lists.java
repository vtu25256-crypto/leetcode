class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode n : lists)
            if (n != null) pq.add(n);

        ListNode d = new ListNode(0), cur = d;

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) pq.add(cur.next);
        }
        return d.next;
    }
}
