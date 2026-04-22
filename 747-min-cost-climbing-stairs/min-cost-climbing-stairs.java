class Solution {
    public int minCostClimbingStairs(int[] c) {
        int a = 0, b = 0;
        for (int i = 2; i <= c.length; i++) {
            int t = Math.min(a + c[i - 2], b + c[i - 1]);
            a = b;
            b = t;
        }
        return b;
    }
}