class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recur for left and right subtree
        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) ||
               hasPathSum(root.right, remainingSum);
    }
}