import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> freq = new HashMap<>();
        // prefix sum 0 has occurred once (empty prefix)
        freq.put(0, 1);

        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum += num;

            // number of previous prefix sums that make subarray sum == goal
            int needed = sum - goal;
            if (freq.containsKey(needed)) {
                result += freq.get(needed);
            }

            // record current prefix sum
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}