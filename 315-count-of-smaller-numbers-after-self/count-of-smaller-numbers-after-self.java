import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        mergeSort(arr, 0, n - 1, count);
        
        List<Integer> res = new ArrayList<>();
        for (int c : count) res.add(c);
        return res;
    }
    
    private void mergeSort(int[][] arr, int l, int r, int[] count) {
        if (l >= r) return;
        int m = (l + r) / 2;
        
        mergeSort(arr, l, m, count);
        mergeSort(arr, m + 1, r, count);
        
        int i = l, j = m + 1, k = 0;
        int[][] temp = new int[r - l + 1][2];
        
        while (i <= m && j <= r) {
            if (arr[i][0] <= arr[j][0]) {
                temp[k] = arr[j++];
            } else {
                count[arr[i][1]] += (r - j + 1);
                temp[k] = arr[i++];
            }
            k++;
        }
        
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        
        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
    }
}