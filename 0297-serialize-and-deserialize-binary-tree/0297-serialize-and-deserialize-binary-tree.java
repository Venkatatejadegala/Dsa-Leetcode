public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X,");
            return;
        }
        sb.append(node.val).append(',');
        build(node.left, sb);
        build(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] arr = data.split(",");
        int[] idx = new int[1];
        return helper(arr, idx);
    }

    private TreeNode helper(String[] arr, int[] idx) {
        if (idx[0] >= arr.length) return null;

        String val = arr[idx[0]++];
        if (val.equals("X") || val.length() == 0) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(arr, idx);
        node.right = helper(arr, idx);
        return node;
    }
}