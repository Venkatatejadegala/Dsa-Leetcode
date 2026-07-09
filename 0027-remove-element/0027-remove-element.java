class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int last = nums.length - 1;
        while (i <= last) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
                last--;
            } else {
                i++;
            }
        }
        return last + 1;
    }
}