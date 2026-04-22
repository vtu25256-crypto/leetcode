import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] p) {
        Arrays.sort(p, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1, end = p[0][1];
        for (int[] x : p) {
            if (x[0] > end) {
                arrows++;
                end = x[1];
            }
        }
        return arrows;
    }
}