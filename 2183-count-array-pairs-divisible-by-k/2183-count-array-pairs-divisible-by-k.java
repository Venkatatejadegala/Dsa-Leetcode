class Solution {
    public long countPairs(int[] nums, int k) {
        int[] freq = new int[k + 1];
        long ans = 0;

        for (int num : nums) {
            int g = gcd(num, k);
            for (int d = 1; d * d <= k; d++) {
                if (k % d != 0) continue;

                if ((long) g * d % k == 0) ans += freq[d];
                int other = k / d;
                if (other != d && (long) g * other % k == 0) ans += freq[other];
            }
            freq[g]++;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}