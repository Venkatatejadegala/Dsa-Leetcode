class Solution {
    private int cameras = 0;

    // 0 -> this node needs a camera
    // 1 -> this node has a camera
    // 2 -> this node is covered
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) cameras++;
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 2; // null is covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If any child needs a camera, place camera here
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // If any child has a camera, this node is covered
        if (left == 1 || right == 1) {
            return 2;
        }

        // Children are covered, but this node is not
        return 0;
    }
}