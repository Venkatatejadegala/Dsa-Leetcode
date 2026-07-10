class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }
}