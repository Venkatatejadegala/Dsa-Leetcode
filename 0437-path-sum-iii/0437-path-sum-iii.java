import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixCount) {
        if (node == null) return 0;

        currSum += node.val;

        int count = prefixCount.getOrDefault(currSum - targetSum, 0);

        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, targetSum, prefixCount);
        count += dfs(node.right, currSum, targetSum, prefixCount);

        prefixCount.put(currSum, prefixCount.get(currSum) - 1);

        return count;
    }
}