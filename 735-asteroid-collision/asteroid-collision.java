import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s = new Stack<>();

        for (int x : a) {
            while (!s.isEmpty() && x < 0 && s.peek() > 0 && s.peek() < -x)
                s.pop();

            if (s.isEmpty() || x > 0 || s.peek() < 0)
                s.push(x);
            else if (s.peek() == -x)
                s.pop();
        }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--)
            res[i] = s.pop();

        return res;
    }
}
