class Solution {
    private Integer prev = null;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            ans = Math.min(ans, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }
}