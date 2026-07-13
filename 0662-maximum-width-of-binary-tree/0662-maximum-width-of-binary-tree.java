import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        long ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));

        while (!q.isEmpty()) {
            int size = q.size();
            long first = q.peek().idx;
            long last = first;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                TreeNode node = cur.node;
                long idx = cur.idx - first; // normalize to avoid overflow
                last = idx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            ans = Math.max(ans, last + 1);
        }

        return (int) ans;
    }

    static class Pair {
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}