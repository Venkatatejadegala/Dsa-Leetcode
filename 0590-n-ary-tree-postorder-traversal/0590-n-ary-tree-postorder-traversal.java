class Solution {
    public List<Integer> postorder(Node root) {
     List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            traversal(child, res);
        }
        res.add(root.val);   
    }
}