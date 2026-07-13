class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode node : q) ans.add(node.val);
                return ans;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && visited.add(node.left)) q.offer(node.left);
                if (node.right != null && visited.add(node.right)) q.offer(node.right);
                TreeNode par = parent.get(node);
                if (par != null && visited.add(par)) q.offer(par);
            }
            dist++;
        }

        return new ArrayList<>();
    }

    private void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}