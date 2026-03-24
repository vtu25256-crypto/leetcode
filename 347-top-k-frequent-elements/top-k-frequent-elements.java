import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap to keep top k elements
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (int num : freq.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }

        // Build result
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = heap.poll();
        return res;
    }
}