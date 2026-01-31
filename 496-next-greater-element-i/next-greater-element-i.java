import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int x : nums2) {
            while (!st.isEmpty() && st.peek() < x)
                map.put(st.pop(), x);
            st.push(x);
        }

        for (int x : st) map.put(x, -1);

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.get(nums1[i]);

        return nums1;
    }
}
