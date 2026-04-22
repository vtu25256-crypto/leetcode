class Solution {
    public int rob(int[] a) {
        int prev = 0, curr = 0;
        for (int n : a) {
            int temp = Math.max(curr, prev + n);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}