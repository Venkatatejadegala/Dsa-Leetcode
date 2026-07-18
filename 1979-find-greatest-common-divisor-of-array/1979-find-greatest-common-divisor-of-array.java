class Solution {
    public int findGCD(int[] nums) {
        // Step 1: find smallest and largest elements
        int mn = nums[0];
        int mx = nums[0];
        for (int x : nums) {
            if (x < mn) mn = x;
            if (x > mx) mx = x;
        }

        // Step 2: compute gcd(mn, mx) using Euclidean algorithm
        return gcd(mn, mx);
    }

    // Iterative Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;  // remainder when a is divided by b
            a = b;          // move b to a
            b = r;          // move remainder to b
        }
        // when b becomes 0, a holds the gcd
        return a;
    }
}