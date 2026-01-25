class Solution {
    public boolean isPalindrome(ListNode h) {
        ListNode s = h, f = h, p = null;
        while (f != null && f.next != null) {
            f = f.next.next;
            ListNode n = s.next;
            s.next = p;
            p = s;
            s = n;
        }
        if (f != null) s = s.next;
        while (p != null)
            if (p.val != s.val) return false;
            else { p = p.next; s = s.next; }
        return true;
    }
}
