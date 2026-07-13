class Solution {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
}