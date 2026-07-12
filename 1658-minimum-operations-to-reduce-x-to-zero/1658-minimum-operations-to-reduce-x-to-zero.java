class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        int currSum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            currSum += nums[right];

            while (currSum > target && left <= right) {
                currSum -= nums[left];
                left++;
            }

            if (currSum == target) {
                int windowLen = right - left + 1;
                if (windowLen > maxLen) {
                    maxLen = windowLen;
                }
            }
        }

        if (maxLen == -1) {
            return -1;
        }
        return n - maxLen;
    }
}