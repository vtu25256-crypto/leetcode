class Solution {
    int k, ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }

    void inorder(TreeNode n) {
        if (n == null) return;
        inorder(n.left);
        if (--k == 0) { ans = n.val; return; }
        inorder(n.right);
    }
}