class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxEnding = nums[0], maxSoFar = nums[0];
        int minEnding = nums[0], minSoFar = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            total += x;

            if (i == 0) continue;

            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);
        }

        if (maxSoFar < 0) return maxSoFar;

        return Math.max(maxSoFar, total - minSoFar);
    }
}