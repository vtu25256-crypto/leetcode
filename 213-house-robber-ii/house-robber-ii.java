class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(help(nums, 0, n - 2),
                        help(nums, 1, n - 1));
    }

    int help(int[] a, int s, int e) {
        int prev = 0, curr = 0;
        for (int i = s; i <= e; i++) {
            int temp = Math.max(curr, prev + a[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}