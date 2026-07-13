import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201]; // values are from -100 to 100

        for (int num : nums) {
            freq[num + 100]++;
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (freq[a + 100] != freq[b + 100]) {
                return freq[a + 100] - freq[b + 100]; // increasing frequency
            }
            return b - a; // decreasing value
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}