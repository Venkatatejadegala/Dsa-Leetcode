class Solution {
    public final TreeNode getTargetCopy(
        final TreeNode original,
        final TreeNode cloned,
        final TreeNode target
    ) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode nodeOriginal, TreeNode nodeCloned, TreeNode target) {
        if (nodeOriginal == null) {
            return null;
        }

        if (nodeOriginal == target) {
            return nodeCloned;
        }

        TreeNode leftResult = dfs(nodeOriginal.left, nodeCloned.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        return dfs(nodeOriginal.right, nodeCloned.right, target);
    }
}