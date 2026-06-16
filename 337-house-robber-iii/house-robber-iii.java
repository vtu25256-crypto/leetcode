class Solution {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) return new int[2];

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int rob = node.val + l[1] + r[1];
        int notRob = Math.max(l[0], l[1]) +
                     Math.max(r[0], r[1]);

        return new int[]{rob, notRob};
    }
}