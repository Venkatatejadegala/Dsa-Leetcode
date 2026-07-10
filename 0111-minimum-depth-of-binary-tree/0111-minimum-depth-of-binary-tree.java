
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If one child is null, we must take depth from the non-null child
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}