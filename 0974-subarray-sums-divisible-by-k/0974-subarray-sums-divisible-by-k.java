class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // freq[r] = how many prefix sums have remainder r
        int[] freq = new int[k];
        freq[0] = 1;  // empty prefix has sum 0, remainder 0

        long prefix = 0;
        long count = 0;

        for (int num : nums) {
            prefix += num;

            int rem = (int) (prefix % k);
            if (rem < 0) {
                rem += k;  // normalize negative remainders
            }

            count += freq[rem]; // all previous same remainders form valid subarrays
            freq[rem]++;        // record current remainder
        }

        return (int) count;
    }
}